package com.eudes.screenmatch.exercicios.interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;

public class Ex006 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Copo", "Jarro", "Alô");

        nomes.sort((a,b) -> a.compareTo(b));

        System.out.println(nomes);
    }
}
