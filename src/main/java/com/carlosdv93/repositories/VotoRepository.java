package com.carlosdv93.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carlosdv93.model.VotoRestaurante;

@Repository
public interface VotoRepository extends CrudRepository<VotoRestaurante, Long> {
	
	public VotoRestaurante findByDataAtualAndUsuario(LocalDate data, Long idUsuario);

	@Query(" SELECT r.nome, o.idRestauranteVotado, COUNT(o.idRestauranteVotado) " + 
			" FROM VotoRestaurante o " + 
			" JOIN Restaurante r on r.id = o.idRestauranteVotado " +
			" WHERE o.dataAtual = ?1" + 
			" GROUP BY o.idRestauranteVotado"
			)
	public Iterable<?> findByDataAtualAndCount(LocalDate now);

}
