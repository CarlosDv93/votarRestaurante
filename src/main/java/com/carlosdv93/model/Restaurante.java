package com.carlosdv93.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String tipoComida;
	
	@OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
	@JsonIgnore
	Set<VotoRestaurante> votos;

	public Restaurante() {
		
	}
	
	public Restaurante(String nome, String tipoComida) {
		this.nome = nome;
		this.tipoComida = tipoComida;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTipoComida() {
		return tipoComida;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public Set<VotoRestaurante> getVotos() {
		return votos;
	}

	public void setVotos(Set<VotoRestaurante> votos) {
		this.votos = votos;
	}

}
