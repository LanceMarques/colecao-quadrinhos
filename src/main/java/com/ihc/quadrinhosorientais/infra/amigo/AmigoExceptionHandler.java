package com.ihc.quadrinhosorientais.infra.amigo;

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
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoEmprestimoVinculadoException;
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoJaCadastradoException;
import com.ihc.quadrinhosorientais.infra.amigo.exceptions.AmigoNaoEncontradoException;

@ControllerAdvice
public class AmigoExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler({AmigoNaoEncontradoException.class})
  public ResponseEntity<Object> handleAmigoNaoEncontradoException(AmigoNaoEncontradoException ex) {
    final String mensagemUsr =
        messageSource.getMessage("amigo-nao-encontrado", null, LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
  }

  @ExceptionHandler({AmigoEmprestimoVinculadoException.class})
  public ResponseEntity<Object> handleAmigoEmprestimoVinculadoException(AmigoEmprestimoVinculadoException ex) {
    final String mensagemUsr =
        messageSource.getMessage("amigo-emprestimo-vinculado", null, LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
  }
  
  @ExceptionHandler({AmigoJaCadastradoException.class})
  public ResponseEntity<Object> handleAmigoJaCadastradoException(AmigoJaCadastradoException ex) {
    final String mensagemUsr =
        messageSource.getMessage("amigo-ja-cadastrado", null, LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
  }
  
}
