package com.carlosdv93.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlosdv93.model.Usuario;
import com.carlosdv93.model.VotoRestaurante;

@Repository
public interface VotoRepository extends CrudRepository<VotoRestaurante, Usuario> {

	public VotoRestaurante findByDataVotoAndUsuario(LocalDate data, Usuario usuario);

	@Query("SELECT r.nome, COUNT(o.restaurante) " + " FROM VotoRestaurante o "
			+ " JOIN Restaurante r on r.id = o.restaurante " 
			+ " WHERE o.dataVoto = ?1" 
			+ " GROUP BY o.restaurante")
	public Iterable<?> findByDataVotoAndCount(LocalDate now);

}
