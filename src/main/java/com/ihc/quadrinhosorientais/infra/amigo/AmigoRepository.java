package com.ihc.quadrinhosorientais.infra.amigo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmigoRepository extends JpaRepository<Amigo, Integer> {

  Optional<Amigo> findByNomeAndApelido(final String nome, final String apelido);

}
