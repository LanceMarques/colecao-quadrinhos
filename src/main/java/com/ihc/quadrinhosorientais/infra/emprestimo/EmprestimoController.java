package com.ihc.quadrinhosorientais.infra.emprestimo;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

  @Autowired
  private EmprestimoService emprestimoService;

  @GetMapping
  @CrossOrigin
  public ResponseEntity<List<Emprestimo>> listar() {

    final List<Emprestimo> emprestimos = this.emprestimoService.listar();
    return ResponseEntity.status(HttpStatus.OK).body(emprestimos);

  }

  @GetMapping("/id/{id}")
  @CrossOrigin
  public ResponseEntity<Emprestimo> buscarPorId(@PathVariable("id") final Integer id) {

    final Emprestimo emprestimoSalvo = this.emprestimoService.buscarPorId(id);
    return ResponseEntity.status(HttpStatus.OK).body(emprestimoSalvo);

  }

  @PostMapping
  @CrossOrigin
  public ResponseEntity<Emprestimo> criar(@Valid @RequestBody final Emprestimo emprestimo) {

    final Emprestimo emprestimosalvo = this.emprestimoService.criar(emprestimo);
    return ResponseEntity.status(HttpStatus.CREATED).body(emprestimosalvo);

  }

  @PutMapping("/id/{id}")
  @CrossOrigin
  public ResponseEntity<Object> atualizar(@PathVariable final Integer id,
      @RequestBody final Emprestimo emprestimo) {

    this.emprestimoService.atualizar(id, emprestimo);
    return ResponseEntity.status(HttpStatus.OK).build();

  }

  @DeleteMapping("/id/{id}")
  @CrossOrigin
  public ResponseEntity<Object> excluir(@PathVariable final Integer id) {

    this.emprestimoService.excluirPorId(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }

}
