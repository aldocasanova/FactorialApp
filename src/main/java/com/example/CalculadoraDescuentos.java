package com.example;

public class CalculadoraDescuentos {

    public double calcularPrecioFinal(double precioOriginal, double porcentajeDescuento) {
        // Regla 2: Excepción si precio original es <= 0
        if (precioOriginal <= 0) {
            throw new IllegalArgumentException("El precio original debe ser mayor que cero");
        }
        
        // Regla 1: Excepción si descuento es < 0 o > 100
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100");
        }
        
        // Regla 4: Si descuento es 0, precio final es igual al original
        if (porcentajeDescuento == 0) {
            return precioOriginal;
        }
        
        // Regla 5: Si descuento es 100, precio final es 0
        if (porcentajeDescuento == 100) {
            return 0.0;
        }

        // Cálculo del descuento
        double precioFinal = precioOriginal - (precioOriginal * (porcentajeDescuento / 100.0));
        
        // Regla 3: Retornar con dos decimales
        return Math.round(precioFinal * 100.0) / 100.0;
    }
}
