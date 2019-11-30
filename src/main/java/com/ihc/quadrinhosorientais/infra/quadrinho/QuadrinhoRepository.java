package com.ihc.quadrinhosorientais.infra.quadrinho;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadrinhoRepository extends JpaRepository<Quadrinho, Integer> {

  List<Quadrinho> findAllByTitulo_Id(final Integer id);

}
