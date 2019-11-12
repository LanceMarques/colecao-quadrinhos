package com.ihc.quadrinhosorientais.infra.titulo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ihc.quadrinhosorientais.infra.titulo.enums.EstadoColecao;

@Entity
@Table(name = "TITULO")
public class Titulo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="NOME")
	private String nome;

	@Column(name="ESTADO_COLECAO")
	@Enumerated(EnumType.STRING)
	private EstadoColecao estadoColecao;

	public Titulo() {
		super();
	}

	public Titulo(Integer id, String nome, EstadoColecao estadoColecao) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadoColecao = estadoColecao;
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

	public EstadoColecao getEstadoColecao() {
		return estadoColecao;
	}

	public void setEstadoColecao(EstadoColecao estadoColecao) {
		this.estadoColecao = estadoColecao;
	}

}
