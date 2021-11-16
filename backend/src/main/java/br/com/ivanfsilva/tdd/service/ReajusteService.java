package br.com.ivanfsilva.tdd.service;

import br.com.ivanfsilva.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste( Funcionario funcionario, Desempenho desempenho ) {

        if ( desempenho == Desempenho.A_DESEJAR ) {
            BigDecimal reajuste = funcionario.getSalario().multiply( new BigDecimal("0.03" ) );
            funcionario.reajustarSalario(reajuste);
        }
    }
}
