package com.carlosdv93.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosdv93.model.Restaurante;
import com.carlosdv93.model.Usuario;
import com.carlosdv93.model.VotoRestaurante;
import com.carlosdv93.repositories.RestauranteRepository;
import com.carlosdv93.repositories.UsuarioRepository;
import com.carlosdv93.repositories.VotoRepository;

@RestController
@RequestMapping(value = "api/voto")
public class VotoController {

	@Autowired
	private VotoRepository repositoryVoto;

	@Autowired
	private UsuarioRepository repositoryUsuario;
	
	@Autowired
	private RestauranteRepository repositoryRestaurante;

	@GetMapping(path = "")
	public Iterable<VotoRestaurante> getAll() {
		return repositoryVoto.findAll();
	}

	@GetMapping(path = "/hoje")
	public Iterable<?> getVotosHoje() {
		Iterable<?> votos = repositoryVoto.findByDataVotoAndCount(LocalDate.now());
		return votos;

	}

	@PostMapping
	public ResponseEntity<?> insertVoto(@Valid @RequestBody VotoRestaurante voto) {

		LocalDate diaAtual = LocalDate.now();

		Optional<Usuario> usuario = repositoryUsuario.findById(voto.getUsuario().getId());
		Optional<Restaurante> restaurante = repositoryRestaurante.findById(voto.getRestaurante().getId());
		
		if (usuario == null || restaurante == null) {
			return ResponseEntity.status(402).body("Usuário ou Restaurante Inválido!");
		} else {
			Usuario usuario2 = usuario.get();
			Restaurante restaurante2 = restaurante.get();
			
			VotoRestaurante votoUsuario = repositoryVoto.findByDataVotoAndUsuario(diaAtual, usuario2);
			
			if (votoUsuario == null) {
				voto.setDataAtual(diaAtual);
				voto.setUsuario(usuario2);
				voto.setRestaurante(restaurante2);
				voto = repositoryVoto.save(voto);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voto).toUri();
				return ResponseEntity.status(201).body(voto);
			} else {
				return ResponseEntity.status(208).body("Usuário já votou hoje!");
			}
		}

	}

}
