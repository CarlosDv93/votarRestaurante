package com.carlosdv93.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.carlosdv93.VotacaoRestauranteApplication;
import com.carlosdv93.model.Restaurante;
import com.carlosdv93.model.Usuario;
import com.carlosdv93.model.VotoRestaurante;
import com.carlosdv93.repositories.RestauranteRepository;
import com.carlosdv93.repositories.UsuarioRepository;
import com.carlosdv93.repositories.VotoRepository;

@Service
public class DBService {
	
private static final Logger log = LoggerFactory.getLogger(VotacaoRestauranteApplication.class);
	
	@Autowired
	private RestauranteRepository restauranteRP;

	@Autowired
	private VotoRepository votoRP;
	
	@Autowired
	private UsuarioRepository usuarioRP;
	
	@Bean
	public boolean instatiateDatabase() {
		
		Restaurante rest1 = new Restaurante("Teste 0", "Brasileira");
		restauranteRP.save(rest1);
		
		Restaurante rest2 = new Restaurante("Teste", "Brasileira");
		restauranteRP.save(rest2);
		
		Restaurante rest3 = new Restaurante("Teste123", "Chinesa");
		restauranteRP.save(rest3);
		
		Restaurante rest4 = new Restaurante("Teste456", "Japonesa");
		restauranteRP.save(rest4);
		
		log.info("Salvo - Restaurantes");
		
		Usuario user1 = new Usuario("Carlos", "123");
		usuarioRP.save(user1);
		Usuario user2 = new Usuario("David", "123");
		usuarioRP.save(user2);
		Usuario user3 = new Usuario("Admin", "123");
		usuarioRP.save(user3);
		Usuario user4 = new Usuario("User", "123");
		usuarioRP.save(user4);
		Usuario user5 = new Usuario("teste", "123");
		usuarioRP.save(user5);
		
		log.info("Salvo - Usuarios");
		
		VotoRestaurante voto1 = new VotoRestaurante(user1, rest1, LocalDate.now());
		votoRP.save(voto1);
		VotoRestaurante voto2 = new VotoRestaurante(user2, rest1, LocalDate.now());
		votoRP.save(voto2);
		VotoRestaurante voto3 = new VotoRestaurante(user3, rest2, LocalDate.now());
		votoRP.save(voto3);
		VotoRestaurante voto4 = new VotoRestaurante(user4, rest4, LocalDate.now());
		votoRP.save(voto4);
		
		log.info("Salvo - Votos");
		
		return true;
	}

}
