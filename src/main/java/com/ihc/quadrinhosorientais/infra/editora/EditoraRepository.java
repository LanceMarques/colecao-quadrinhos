package com.ihc.quadrinhosorientais.infra.editora;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {

	Optional<Editora> findByNome(String nome);

}
