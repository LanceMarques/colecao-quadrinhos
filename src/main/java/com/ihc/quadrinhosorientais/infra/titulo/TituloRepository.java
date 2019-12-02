package com.ihc.quadrinhosorientais.infra.titulo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo, Integer> {

  Optional<Titulo> findByTituloAndEditora(final String titulo, final String editora);

}
