package com.ihc.quadrinhosorientais.infra.emprestimo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ihc.quadrinhosorientais.handler.Erro;
import com.ihc.quadrinhosorientais.infra.emprestimo.exceptions.EmprestimoNaoEncontradoException;

@ControllerAdvice
public class EmprestimoExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler({EmprestimoNaoEncontradoException.class})
  public ResponseEntity<Object> handleEmprestimoNaoEncontradoException(
      EmprestimoNaoEncontradoException ex) {
    final String mensagemUsr =
        messageSource.getMessage("emprestimo-nao-encontrado", null, LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
  }
}
