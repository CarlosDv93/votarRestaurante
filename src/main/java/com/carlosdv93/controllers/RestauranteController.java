package com.carlosdv93.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carlosdv93.model.Restaurante;
import com.carlosdv93.repositories.RestauranteRepository;


@RestController
@RequestMapping(value="api/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteRepository repository;
	
	@GetMapping(path="")
	public Iterable<Restaurante> getAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Restaurante> insert(@Valid @RequestBody Restaurante restaurante){
		restaurante = repository.save(restaurante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(restaurante).toUri();
		return ResponseEntity.status(201).body(restaurante);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Restaurante> atualizarPessoa(@PathVariable Restaurante id, @RequestBody Restaurante restaurante){
		Optional<Restaurante> restaurante1 = repository.findById(id);
		if(restaurante1 != null) {
			Restaurante restaurante2 = restaurante1.get();
			restaurante2.setNome(restaurante1.get().getNome());
			restaurante2.setTipoComida(restaurante1.get().getTipoComida());
			repository.save(restaurante2);
			return ResponseEntity.ok(restaurante2);
		} else {
			return (ResponseEntity<Restaurante>) ResponseEntity.badRequest();
		}
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletarPessoa(@PathVariable Restaurante id){
		repository.deleteById(id);
		return ResponseEntity.ok(null);
	}
}
