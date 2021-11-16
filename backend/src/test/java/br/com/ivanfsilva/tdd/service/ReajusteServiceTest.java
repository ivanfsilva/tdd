package br.com.ivanfsilva.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ivanfsilva.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerdeTresPocentoQuandoDesempehoForAdesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario( "José", LocalDate.now(), new BigDecimal( "1000" ) );

        service.concederReajuste( funcionario, Desempenho.A_DESEJAR );

        assertEquals( new BigDecimal( "1030.00" ), funcionario.getSalario() );
    }

}
