package com.carlosdv93.service;

import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.carlosdv93.VotacaoRestauranteApplication;
import com.carlosdv93.model.Restaurante;
import com.carlosdv93.model.VotoRestaurante;
import com.carlosdv93.repositories.RestauranteRepository;
import com.carlosdv93.repositories.VotoRepository;

@Service
public class DBService {
	
private static final Logger log = LoggerFactory.getLogger(VotacaoRestauranteApplication.class);
	
	@Autowired
	private RestauranteRepository restauranteRP;

	@Autowired
	private VotoRepository votoRP;
	
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
		
		VotoRestaurante voto1 = new VotoRestaurante(Long.valueOf(1L), LocalDate.now(), Long.valueOf(1L));
		votoRP.save(voto1);
		
		VotoRestaurante voto2 = new VotoRestaurante(Long.valueOf(2L), LocalDate.now(), Long.valueOf(2L));
		votoRP.save(voto2);
		
		VotoRestaurante voto3 = new VotoRestaurante(Long.valueOf(2L), LocalDate.now(), Long.valueOf(2L));
		votoRP.save(voto3);
		
		log.info("Salvo - Votos");
		
		return true;
	}

}
