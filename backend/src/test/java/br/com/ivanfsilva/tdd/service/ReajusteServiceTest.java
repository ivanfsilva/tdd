package br.com.ivanfsilva.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ivanfsilva.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario( "José", LocalDate.now(), new BigDecimal( "1000" ) );
    }

    @Test
    public void reajusteDeveriaSerdeTresPorcentoQuandoDesempehoForAdesejar() {
        service.concederReajuste( funcionario, Desempenho.A_DESEJAR );
        assertEquals( new BigDecimal( "1030.00" ), funcionario.getSalario() );
    }

    @Test
    public void reajusteDeveriaSerdeQuinzePorcentoQuandoDesempehoForBom() {
        service.concederReajuste( funcionario, Desempenho.BOM );
        assertEquals( new BigDecimal( "1150.00" ), funcionario.getSalario() );
    }

    @Test
    public void reajusteDeveriaSerdeVintePorcentoQuandoDesempehoForOtimo() {
        service.concederReajuste( funcionario, Desempenho.OTIMO );
        assertEquals( new BigDecimal( "1200.00" ), funcionario.getSalario() );
    }

}
