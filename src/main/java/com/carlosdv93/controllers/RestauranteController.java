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

import com.carlosdv93.model.RestauranteModel;
import com.carlosdv93.repositories.RestauranteRepository;


@RestController
@RequestMapping(value="api/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteRepository repository;
	
	@GetMapping(path="")
	public Iterable<RestauranteModel> getAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<RestauranteModel> insert(@Valid @RequestBody RestauranteModel restaurante){
		restaurante = repository.save(restaurante);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(restaurante).toUri();
		return ResponseEntity.status(201).body(restaurante);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<RestauranteModel> atualizarPessoa(@PathVariable Long id, @RequestBody RestauranteModel restaurante){
		Optional<RestauranteModel> restaurante1 = repository.findById(id);
		if(restaurante1 != null) {
			RestauranteModel restaurante2 = restaurante1.get();
			restaurante2.setNome(restaurante1.get().getNome());
			restaurante2.setTipoComida(restaurante1.get().getTipoComida());
			repository.save(restaurante2);
			return ResponseEntity.ok(restaurante2);
		} else {
			return (ResponseEntity<RestauranteModel>) ResponseEntity.badRequest();
		}
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletarPessoa(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.ok(null);
	}
}
