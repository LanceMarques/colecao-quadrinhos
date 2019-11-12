package com.ihc.quadrinhosorientais.infra.emprestimo.enums;

public enum StatusEmprestimo {

	ABERTO("Em aberto"), DEVOLVIDO("Devolvido");

	private final String status;

	StatusEmprestimo(final String status){
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
