package com.eudes.screenmatch.exercicios.interfaces;

import java.util.Arrays;
import java.util.List;

public class Ex005 {
    public static void main(String[] args) {
        List<Integer> lista =  Arrays.asList(1, 2, 3, 4);
        IMultiporTres multiporTres = a -> a * 3;

        lista.replaceAll(listaNew -> multiporTres.numeros(listaNew));

        System.out.println(lista);
    }
}
