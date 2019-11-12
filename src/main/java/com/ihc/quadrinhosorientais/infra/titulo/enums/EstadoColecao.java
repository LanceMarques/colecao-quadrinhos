package com.ihc.quadrinhosorientais.infra.titulo.enums;

public enum EstadoColecao {

	ABERTO("Aberto"), FINALIZADO("Finalizado"), DESCONTINUADO("Descontinuado");
	
	private final String estado;
	
	EstadoColecao(final String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}

}
