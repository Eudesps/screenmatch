package com.eudes.screenmatch.exercicios.interfaces;

public class Ex007 {
    public static void main(String[] args) {
        IDividendo dividendo = (n1, n2) -> {
            if(n2 == 0) throw new ArithmeticException("Divisor igual a zero");
            return n1/n2;
        };

        try {
            System.out.println(dividendo.dividendo(10, 2)); // Esperado: 5
            System.out.println(dividendo.dividendo(10, 0)); // Esperado: Exceção
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}
