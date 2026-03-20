package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescuentosTest {

    private final CalculadoraDescuentos calc = new CalculadoraDescuentos();

    @Test
    void testDescuentoValido() {
        // 10% de 100 debería ser 90.0
        assertEquals(90.0, calc.calcularPrecioFinal(100.0, 10.0));
    }

    @Test
    void testDescuentoCero() {
        // Regla 4: Si descuento es 0, precio final es original
        assertEquals(50.5, calc.calcularPrecioFinal(50.5, 0.0));
    }

    @Test
    void testDescuentoCien() {
        // Regla 5: Si descuento es 100, precio final es 0
        assertEquals(0.0, calc.calcularPrecioFinal(200.0, 100.0));
    }

    @Test
    void testPrecioOriginalInvalido() {
        // Regla 2: Excepción si precio original es <= 0
        assertThrows(IllegalArgumentException.class, () -> calc.calcularPrecioFinal(0.0, 10.0));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularPrecioFinal(-5.0, 10.0));
    }

    @Test
    void testDescuentoInvalido() {
        // Regla 1: Excepción si descuento es < 0 o > 100
        assertThrows(IllegalArgumentException.class, () -> calc.calcularPrecioFinal(100.0, -1.0));
        assertThrows(IllegalArgumentException.class, () -> calc.calcularPrecioFinal(100.0, 101.0));
    }
}
