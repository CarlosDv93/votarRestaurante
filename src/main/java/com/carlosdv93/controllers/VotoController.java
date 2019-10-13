package com.carlosdv93.controllers;

import java.net.URI;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosdv93.model.VotoRestaurante;
import com.carlosdv93.repositories.VotoRepository;

@RestController
@RequestMapping(value = "api/voto")
public class VotoController {

	@Autowired
	private VotoRepository repository;

	@GetMapping(path = "")
	public Iterable<VotoRestaurante> getAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/hoje")
	public Iterable<?> getVotosHoje() {
		Iterable<?> votos = repository.findByDataVotoAndCount(LocalDate.now());
		return votos;
		
	}

	@PostMapping
	public ResponseEntity<?> insertVoto(@Valid @RequestBody VotoRestaurante voto) {

		LocalDate diaAtual = LocalDate.now();

		VotoRestaurante votoUsuario = repository.findByDataVotoAndUsuario(diaAtual, voto.getUsuario());

		if (votoUsuario == null) {
			voto.setDataAtual(diaAtual);
			voto = repository.save(voto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(voto).toUri();
			return ResponseEntity.status(201).body(voto);
		} else {
			return ResponseEntity.status(208).body("Usuário já votou hoje!");
		}

	}

}
