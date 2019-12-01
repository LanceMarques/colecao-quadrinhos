package com.ihc.quadrinhosorientais.infra.quadrinho.enums;

public enum TipoQuadrinho {

  MANGA("Manga"), SHOUNEN("Shounen"), SHOJOH("Shojo");

  private final String tipo;

  TipoQuadrinho(final String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return this.tipo;
  }

}
