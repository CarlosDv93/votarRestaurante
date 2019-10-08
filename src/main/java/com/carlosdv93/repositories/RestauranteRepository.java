package com.carlosdv93.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlosdv93.model.RestauranteModel;

@Repository
public interface RestauranteRepository extends CrudRepository<RestauranteModel, Long> {

}
