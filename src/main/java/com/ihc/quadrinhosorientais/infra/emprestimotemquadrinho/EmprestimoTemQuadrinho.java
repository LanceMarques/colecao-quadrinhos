package com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ihc.quadrinhosorientais.infra.emprestimo.Emprestimo;
import com.ihc.quadrinhosorientais.infra.quadrinho.Quadrinho;

@Entity
@Table(name = "EMPRESTIMO_TEM_QUADRINHO")
public class EmprestimoTemQuadrinho {
	
	@EmbeddedId
	private EmprestimoTemQuadrinhoId id;
	
	@ManyToOne
	@MapsId("emprestimoId")
	private Emprestimo emprestimo;
	
	@ManyToOne
	@MapsId("quadrinhoId")
	private Quadrinho quadrinho;
	
	public EmprestimoTemQuadrinho() {
		// TODO Auto-generated constructor stub
	}

	public EmprestimoTemQuadrinho(Emprestimo emprestimo, Quadrinho quadrinho) {
		super();
		this.emprestimo = emprestimo;
		this.quadrinho = quadrinho;
		this.setId(new EmprestimoTemQuadrinhoId(emprestimo.getId(), quadrinho.getId()));
	}

	public EmprestimoTemQuadrinhoId getId() {
		return id;
	}

	public void setId(EmprestimoTemQuadrinhoId id) {
		this.id = id;
	}

	@JsonIgnore
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Quadrinho getQuadrinho() {
		return quadrinho;
	}

	public void setQuadrinho(Quadrinho quadrinho) {
		this.quadrinho = quadrinho;
	}
		
}