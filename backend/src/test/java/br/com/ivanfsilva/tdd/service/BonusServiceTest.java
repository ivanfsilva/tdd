package br.com.ivanfsilva.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.ivanfsilva.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();

//        Primeira maneira de testar um exceção ( eu prefiro essa por ser mais limpa )
//        assertThrows( IllegalArgumentException.class,
//                () -> service.calcularBonus(
//                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "25000" ) ) ) );

//        Segunda maneira, se precisar testar o retorno da exceção ( mensagem, etc )
        try {
            service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "25000" ) ) );
            fail( "deveria ocorrer uma exception" );
        } catch ( Exception e ) {
            assertEquals( "Funcionário não pode receber um bônus maior que 1.000 !", e.getMessage() );
        }

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "2500" ) ));

        assertEquals( new BigDecimal( "250.00" ), bonus );
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "10000" ) ) );

        assertEquals( new BigDecimal( "1000.00" ), bonus );
    }

}
