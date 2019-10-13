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

import com.carlosdv93.model.Usuario;
import com.carlosdv93.model.Usuario;
import com.carlosdv93.repositories.UsuarioRepository;


@RestController
@RequestMapping(value="api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping(path="")
	public Iterable<Usuario> getAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@Valid @RequestBody Usuario usuario){
		usuario = repository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuario).toUri();
		return ResponseEntity.status(201).body(usuario);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> atualizarPessoa(@PathVariable Long id, @RequestBody Usuario usuario){
		Optional<Usuario> usuario1 = repository.findById(id);
		if(usuario1 != null) {
			Usuario usuario2 = usuario1.get();
			usuario2.setUsername(usuario1.get().getUsername());
			usuario2.setPassword(usuario1.get().getPassword());
			repository.save(usuario2);
			return ResponseEntity.ok(usuario2);
		} else {
			return (ResponseEntity<Usuario>) ResponseEntity.badRequest();
		}
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletarPessoa(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.ok(null);
	}
}
