package com.carlosdv93.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.carlosdv93.VotacaoRestauranteApplication;
import com.carlosdv93.model.RestauranteModel;
import com.carlosdv93.repositories.RestauranteRepository;

@Service
public class DBService {
	
private static final Logger log = LoggerFactory.getLogger(VotacaoRestauranteApplication.class);
	
	@Autowired
	private RestauranteRepository restauranteRP;
	
	@Bean
	public boolean instatiateDatabase() {
		
		RestauranteModel rest1 = new RestauranteModel("Teste 0", "Brasileira");
		restauranteRP.save(rest1);
		
		RestauranteModel rest2 = new RestauranteModel("Teste", "Brasileira");
		restauranteRP.save(rest2);
		
		RestauranteModel rest3 = new RestauranteModel("Teste123", "Chinesa");
		restauranteRP.save(rest3);
		
		RestauranteModel rest4 = new RestauranteModel("Teste456", "Japonesa");
		restauranteRP.save(rest4);
		
		log.info("Salvo");
		
		return true;
	}

}
