package com.ihc.quadrinhosorientais.infra.emprestimo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.ihc.quadrinhosorientais.infra.amigo.Amigo;
import com.ihc.quadrinhosorientais.infra.emprestimo.enums.StatusEmprestimo;
import com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho.EmprestimoTemQuadrinho;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "AMIGO_ID")
  private Amigo amigo;

  @JsonFormat(pattern = "YYYY-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "DATA_REALIZACAO")
  private LocalDate dataRealizacao;

  @JsonFormat(pattern = "YYYY-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "DATA_DEVOLUCAO")
  private LocalDate dataDevolucao;

  @Column(name = "STATUS")
  private StatusEmprestimo statusEmprestimo;

  @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
  private List<EmprestimoTemQuadrinho> quadrinhos;

  public Emprestimo() {
    super();
  }

  public Emprestimo(Integer id, Amigo amigo, LocalDate dataRealizacao, LocalDate dataDevolucao,
      StatusEmprestimo statusEmprestimo, List<EmprestimoTemQuadrinho> quadrinhos) {
    super();
    this.id = id;
    this.amigo = amigo;
    this.dataRealizacao = dataRealizacao;
    this.dataDevolucao = dataDevolucao;
    this.statusEmprestimo = statusEmprestimo;
    this.quadrinhos = quadrinhos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Amigo getAmigo() {
    return amigo;
  }

  public void setAmigo(Amigo amigo) {
    this.amigo = amigo;
  }

  public LocalDate getDataRealizacao() {
    return dataRealizacao;
  }

  public void setDataRealizacao(LocalDate dataRealizacao) {
    this.dataRealizacao = dataRealizacao;
  }

  public LocalDate getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(LocalDate dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public StatusEmprestimo getStatusEmprestimo() {
    return statusEmprestimo;
  }

  public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
    this.statusEmprestimo = statusEmprestimo;
  }

  public List<EmprestimoTemQuadrinho> getQuadrinhos() {
    return quadrinhos;
  }

  public void setQuadrinhos(List<EmprestimoTemQuadrinho> quadrinhos) {
    this.quadrinhos = quadrinhos;
  }

}
