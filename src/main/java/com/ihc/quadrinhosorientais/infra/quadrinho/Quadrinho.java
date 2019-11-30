package com.ihc.quadrinhosorientais.infra.quadrinho;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho.EmprestimoTemQuadrinho;
import com.ihc.quadrinhosorientais.infra.quadrinho.enums.EstadoConservacao;
import com.ihc.quadrinhosorientais.infra.titulo.Titulo;

@Entity
@Table(name = "QUADRINHO")
public class Quadrinho {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "TITULO_ID")
  private Titulo titulo;

  @Column(name = "ESTADO_CONSERVACAO")
  private EstadoConservacao estadoConservacao;

  @Min(value = 0)
  @Max(value = 20)
  @Column(name = "QUANTIDADE")
  private Integer quantidade;

  @Column(name = "VOLUME")
  private Integer volume;

  @Column(name = "VALOR")
  private double valor;

  @OneToMany(mappedBy = "quadrinho")
  @JsonIgnore
  List<EmprestimoTemQuadrinho> emprestimos = new ArrayList<EmprestimoTemQuadrinho>();

  public Quadrinho() {
    super();
  }

  public Quadrinho(Integer id, Titulo titulo, EstadoConservacao estadoConservacao,
      Integer quantidade, Integer volume, double valor, List<EmprestimoTemQuadrinho> emprestimos) {
    super();
    this.id = id;
    this.titulo = titulo;
    this.estadoConservacao = estadoConservacao;
    this.quantidade = quantidade;
    this.volume = volume;
    this.valor = valor;
    this.emprestimos = emprestimos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Titulo getTitulo() {
    return titulo;
  }

  public void setTitulo(Titulo titulo) {
    this.titulo = titulo;
  }

  public EstadoConservacao getEstadoConservacao() {
    return estadoConservacao;
  }

  public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
    this.estadoConservacao = estadoConservacao;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public List<EmprestimoTemQuadrinho> getEmprestimos() {
    return emprestimos;
  }

  public void setEmprestimos(List<EmprestimoTemQuadrinho> emprestimos) {
    this.emprestimos = emprestimos;
  }

  public boolean temEmprestimoVinculado() {

    return !this.emprestimos.isEmpty();

  }

}
