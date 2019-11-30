package com.ihc.quadrinhosorientais.infra.utils;

import java.time.LocalDate;

public class QuadrinhosOrientaisUtils {

  public static LocalDate criarLocalDate(final int dia, final int mes, final int ano) {

    return LocalDate.of(ano, mes, dia);

  }

}
