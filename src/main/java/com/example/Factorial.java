package com.example;

public class Factorial {
    public static long calcular(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser >= 0");
        }
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
