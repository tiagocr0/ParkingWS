package br.edu.ifsc.parking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vagas {
	
	@JsonProperty(value="Numero", required = false)
	public Integer numero;
	
	@JsonProperty(value="Ocupada", required = false)
	public Boolean situacao;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
}
