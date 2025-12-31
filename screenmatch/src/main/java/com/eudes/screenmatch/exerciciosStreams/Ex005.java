package com.eudes.screenmatch.exerciciosStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 5 - Dada uma lista de números inteiros, separe os números pares dos ímpares.
public class Ex005 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<String , List<Integer>> imparEpar = numeros.stream()
                .collect(Collectors.groupingBy( e -> e % 2 == 0 ? "Par": "impar"));

        System.out.println(imparEpar);
    }
}
