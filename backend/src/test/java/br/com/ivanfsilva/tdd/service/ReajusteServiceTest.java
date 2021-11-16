package br.com.ivanfsilva.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ivanfsilva.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerdeTresPorcentoQuandoDesempehoForAdesejar() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario( "José", LocalDate.now(), new BigDecimal( "1000" ) );

        service.concederReajuste( funcionario, Desempenho.A_DESEJAR );

        assertEquals( new BigDecimal( "1030.00" ), funcionario.getSalario() );
    }

    @Test
    public void reajusteDeveriaSerdeQuinzePorcentoQuandoDesempehoForBom() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario( "José", LocalDate.now(), new BigDecimal( "1000" ) );

        service.concederReajuste( funcionario, Desempenho.BOM );

        assertEquals( new BigDecimal( "1150.00" ), funcionario.getSalario() );
    }

    @Test
    public void reajusteDeveriaSerdeVintePorcentoQuandoDesempehoForOtimo() {
        ReajusteService service = new ReajusteService();

        Funcionario funcionario = new Funcionario( "José", LocalDate.now(), new BigDecimal( "1000" ) );

        service.concederReajuste( funcionario, Desempenho.OTIMO );

        assertEquals( new BigDecimal( "1200.00" ), funcionario.getSalario() );
    }

}
