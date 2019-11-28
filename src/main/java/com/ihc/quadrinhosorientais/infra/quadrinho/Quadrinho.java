package com.ihc.quadrinhosorientais.infra.quadrinho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ihc.quadrinhosorientais.infra.editora.Editora;
import com.ihc.quadrinhosorientais.infra.quadrinho.enums.EstadoConservacao;
import com.ihc.quadrinhosorientais.infra.quadrinho.enums.TipoQuadrinho;
import com.ihc.quadrinhosorientais.infra.titulo.Titulo;

@Entity
@Table(name="QUADRINHO")
public class Quadrinho {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TITULO_ID")
	private Titulo titulo;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="EDITORA_ID")
	private Editora editora;
	
	@Column(name="TIPO")
	private TipoQuadrinho tipoQuadrinho;
	
	@Column(name="ESTADO_CONSERVACAO")
	private EstadoConservacao estadoConservacao;
	
	@Min(value = 0)
	@Max(value = 20)
	@Column(name="QUANTIDADE")
	private Integer quantidade;
	
	//@Min(value = 0)
	//@Max(value = 100)
	@Column(name="VOLUME")
	private Integer volume;
	
	@Column(name="VALOR")
	private double valor;
	
	@Column(name="AVALIACAO")
	private Integer avaliacao;
	
	@Column(name="OBSERVACAO")
	private String observacao;
	
	public Quadrinho() {
		super();
	}

	public Quadrinho(Integer id, Titulo titulo, Editora editora, TipoQuadrinho tipoQuadrinho,
			EstadoConservacao estadoConservacao, Integer quantidade, Integer volume, double valor, Integer avaliacao,
			String observacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.tipoQuadrinho = tipoQuadrinho;
		this.estadoConservacao = estadoConservacao;
		this.quantidade = quantidade;
		this.volume = volume;
		this.valor = valor;
		this.avaliacao = avaliacao;
		this.observacao = observacao;
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

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public TipoQuadrinho getTipoQuadrinho() {
		return tipoQuadrinho;
	}

	public void setTipoQuadrinho(TipoQuadrinho tipoQuadrinho) {
		this.tipoQuadrinho = tipoQuadrinho;
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

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
		
}
