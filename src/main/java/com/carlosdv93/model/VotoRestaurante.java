package com.carlosdv93.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voto")
public class VotoRestaurante  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private RestauranteModel restauranteModel; 
	private Date dataAtual;
	
	private Usuario usuario;
	
	public VotoRestaurante() {
		
	}

	public VotoRestaurante(RestauranteModel restauranteModel, Date dataAtual, Usuario usuario) {
		super();
		this.restauranteModel = restauranteModel;
		this.dataAtual = dataAtual;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public RestauranteModel getRestauranteModel() {
		return restauranteModel;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setRestauranteModel(RestauranteModel restauranteModel) {
		this.restauranteModel = restauranteModel;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
