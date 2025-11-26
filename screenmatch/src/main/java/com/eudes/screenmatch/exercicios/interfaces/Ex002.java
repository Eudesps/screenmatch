package com.eudes.screenmatch.exercicios.interfaces;

public class Ex002 {
    public static void main(String[] args) {
        INumeroPrimo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(primo.numeroPrimo(11));
        System.out.println(primo.numeroPrimo(12));
    }
}
