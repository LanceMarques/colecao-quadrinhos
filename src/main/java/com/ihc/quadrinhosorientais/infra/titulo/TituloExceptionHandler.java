package com.ihc.quadrinhosorientais.infra.titulo;

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
import com.ihc.quadrinhosorientais.infra.titulo.exceptions.TituloNaoEncontradoException;
import com.ihc.quadrinhosorientais.infra.titulo.exceptions.TituloQuadrinhoAssociadoException;

@ControllerAdvice
public class TituloExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler({TituloNaoEncontradoException.class})
  public ResponseEntity<Object> handleTituloNaoEncontradoException(
      TituloNaoEncontradoException ex) {
    
    final String mensagemUsr =
        messageSource.getMessage("titulo-nao-encontrado", null, LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    
  }

  @ExceptionHandler({TituloQuadrinhoAssociadoException.class})
  public ResponseEntity<Object> handleTituloQuadrinhoAssociadoException(
      TituloQuadrinhoAssociadoException ex) {
    
    final String mensagemUsr = messageSource.getMessage("titulo-quadrinho-associado", null,
        LocaleContextHolder.getLocale());
    final String mensagemDev = ex.toString();
    final List<Erro> erros = Arrays.asList(new Erro(mensagemUsr, mensagemDev));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    
  }

}
