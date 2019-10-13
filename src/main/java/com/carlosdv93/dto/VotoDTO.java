package com.carlosdv93.dto;

public class VotoDTO {

	private String nomeRestaurante;
	private String qtdeVotos;

	public VotoDTO() {

	}

	public VotoDTO(String nomeRestaurante, String qtdeVotos) {
		super();
		this.nomeRestaurante = nomeRestaurante;
		this.qtdeVotos = qtdeVotos;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	public String getQtdeVotos() {
		return qtdeVotos;
	}

	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	public void setQtdeVotos(String qtdeVotos) {
		this.qtdeVotos = qtdeVotos;
	}

}
