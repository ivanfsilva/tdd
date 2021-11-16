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
        BigDecimal bonus = service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "25000" ) ));

        assertEquals( new BigDecimal("0.00"), bonus );
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "2500" ) ));

        assertEquals( new BigDecimal("250.00"), bonus );
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario( "Rodrigo", LocalDate.now(), new BigDecimal( "10000" ) ));

        assertEquals( new BigDecimal("1000.00"), bonus );
    }

}