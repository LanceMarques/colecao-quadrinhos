package com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmprestimoTemQuadrinhoId implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name = "EMPRESTIMO_ID")
  private Integer emprestimoId;

  @Column(name = "QUADRINHO_ID")
  private Integer quadrinhoId;

  public EmprestimoTemQuadrinhoId() {
    super();
  }

  public EmprestimoTemQuadrinhoId(Integer emprestimoId, Integer quadrinhoId) {
    super();
    this.emprestimoId = emprestimoId;
    this.quadrinhoId = quadrinhoId;
  }

  public Integer getEmprestimoId() {
    return emprestimoId;
  }

  public void setEmprestimoId(Integer emprestimoId) {
    this.emprestimoId = emprestimoId;
  }

  public Integer getQuadrinhoId() {
    return quadrinhoId;
  }

  public void setQuadrinhoId(Integer quadrinhoId) {
    this.quadrinhoId = quadrinhoId;
  }

}
