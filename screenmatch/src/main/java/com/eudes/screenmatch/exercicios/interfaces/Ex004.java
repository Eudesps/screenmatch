package com.eudes.screenmatch.exercicios.interfaces;

public class Ex004 {
    public static void main(String[] args) {
        IVerificaStringPoli verificaStringPoli = s -> s.equals(new StringBuilder(s).reverse().toString());

        System.out.println(verificaStringPoli.verificarPalindromo("ovo"));
        System.out.println(verificaStringPoli.verificarPalindromo("java"));
    }
}
