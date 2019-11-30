package com.ihc.quadrinhosorientais.infra.amigo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho.EmprestimoTemQuadrinho;

@Entity
@Table(name = "AMIGO")
public class Amigo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Size(min = 3, max = 20)
  @NotNull
  @Column(name = "NOME")
  private String nome;

  @Column(name = "APELIDO")
  private String apelido;

  @Column(name = "NUMERO_CELULAR")
  private String celular;

  @OneToMany(mappedBy = "quadrinho")
  @JsonIgnore
  private List<EmprestimoTemQuadrinho> emprestimos = new ArrayList<EmprestimoTemQuadrinho>();

  public Amigo() {
    super();
  }

  public Amigo(Integer id, String nome, String apelido, String celular,
      List<EmprestimoTemQuadrinho> emprestimos) {
    super();
    this.id = id;
    this.nome = nome;
    this.apelido = apelido;
    this.celular = celular;
    this.emprestimos = emprestimos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
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
