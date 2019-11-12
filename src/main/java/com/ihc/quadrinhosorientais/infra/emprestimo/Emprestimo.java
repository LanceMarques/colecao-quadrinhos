package com.ihc.quadrinhosorientais.infra.emprestimo;

import java.sql.Date;
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

import com.ihc.quadrinhosorientais.infra.amigo.Amigo;
import com.ihc.quadrinhosorientais.infra.emprestimo.enums.StatusEmprestimo;
import com.ihc.quadrinhosorientais.infra.emprestimotemquadrinho.EmprestimoTemQuadrinho;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "AMIGO_ID")
	private Amigo amigo;

	@Column(name = "DATA_REALIZACAO")
	private Date dataRealizacao;

	@Column(name = "DATA_DEVOLUCAO")
	private Date dataDevolucao;

	@Column(name = "STATUS")
	private StatusEmprestimo statusEmprestimo;

	@OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
	private List<EmprestimoTemQuadrinho> quadrinhos;
	
	public Emprestimo() {
		super();
	}

	public Emprestimo(Integer id, Amigo amigo, Date dataRealizacao, Date dataDevolucao,
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

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
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
