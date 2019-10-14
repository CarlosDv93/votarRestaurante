package com.carlosdv93.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto")
public class VotoRestaurante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	
	private LocalDate dataVoto;

	public VotoRestaurante() {

	}
	
	public VotoRestaurante(Usuario usuario, Restaurante restaurante, LocalDate dataAtual) {
		super();
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.dataVoto = dataAtual;
	}	

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public LocalDate getDataAtual() {
		return dataVoto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public void setDataAtual(LocalDate dataAtual) {
		this.dataVoto = dataAtual;
	}

}
