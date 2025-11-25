package com.eudes.screenmatch.exercicios.interfaces;

public class Ex001 {
    public static void main(String[] args) {
        IMultiplicacao multiplicacao = (a,b) -> a*b;

        System.out.println(multiplicacao.multiplicacao(4,10));
    }
}
