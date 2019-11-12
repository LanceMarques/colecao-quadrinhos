package com.ihc.quadrinhosorientais.infra.quadrinho.enums;

public enum EstadoConservacao {

	NOVO("Novo"), USADO("Usado");

	private final String estado;

	EstadoConservacao(final String estado){
		this.estado = estado;
	}

	public String getEstado() {
		return this.estado;
	}
	
}
