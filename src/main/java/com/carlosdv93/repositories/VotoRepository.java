package com.carlosdv93.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlosdv93.model.VotoRestaurante;

@Repository
public interface VotoRepository extends CrudRepository<VotoRestaurante, Long> {
	
	

}
