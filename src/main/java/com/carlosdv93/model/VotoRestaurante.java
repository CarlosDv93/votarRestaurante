package com.carlosdv93.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voto")
public class VotoRestaurante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long idRestauranteVotado;
	
	private LocalDate dataAtual;

	private Long usuario;

	public VotoRestaurante() {

	}

	//TODO: Mantendo inicialmente o valor do ID, posteriormente fazer o vínculo.
	public VotoRestaurante(Long restauranteModel, LocalDate localDate, Long usuario) {
		this.idRestauranteVotado = restauranteModel;
		this.dataAtual = localDate;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public Long getRestauranteModel() {
		return idRestauranteVotado;
	}

	public LocalDate getDataAtual() {
		return dataAtual;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setRestauranteModel(Long restauranteModel) {
		this.idRestauranteVotado = restauranteModel;
	}

	public void setDataAtual(LocalDate dataAtual) {
		this.dataAtual = dataAtual;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
}
