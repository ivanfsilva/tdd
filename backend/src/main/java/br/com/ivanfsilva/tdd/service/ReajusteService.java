package br.com.ivanfsilva.tdd.service;

import br.com.ivanfsilva.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste( Funcionario funcionario, Desempenho desempenho ) {

        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}
