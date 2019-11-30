package com.ihc.quadrinhosorientais.infra.quadrinho;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quadrinhos")
public class QuadrinhoController {

  @Autowired
  private QuadrinhoService quadrinhoService;

  @GetMapping("/titulo/{idTitulo}")
  public ResponseEntity<List<Quadrinho>> listarPorTitulo(
      @PathVariable("idTitulo") final Integer idTitulo) {

    final List<Quadrinho> quadrinhos = this.quadrinhoService.listarPorTitulo(idTitulo);
    return ResponseEntity.status(HttpStatus.OK).body(quadrinhos);

  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Quadrinho> buscarPorId(@PathVariable("id") final Integer id) {

    final Quadrinho quadrinhoSalvo = this.quadrinhoService.buscarPorId(id);
    return ResponseEntity.status(HttpStatus.OK).body(quadrinhoSalvo);

  }

  @PostMapping
  public ResponseEntity<Quadrinho> criar(@RequestBody final Quadrinho quadrinho) {

    final Quadrinho quadrinhosalvo = this.quadrinhoService.criar(quadrinho);
    return ResponseEntity.status(HttpStatus.CREATED).body(quadrinhosalvo);

  }

  @PutMapping("/id/{id}")
  public ResponseEntity<Quadrinho> atualizar(@PathVariable final Integer id,
      @RequestBody final Quadrinho quadrinho) {

    final Quadrinho QuadrinhoAtualizado = this.quadrinhoService.atualizar(id, quadrinho);
    return ResponseEntity.status(HttpStatus.OK).body(QuadrinhoAtualizado);

  }

  @DeleteMapping("/id/{id}")
  public ResponseEntity<?> excluir(@PathVariable final Integer id) {

    this.quadrinhoService.excluirPorId(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }

}
