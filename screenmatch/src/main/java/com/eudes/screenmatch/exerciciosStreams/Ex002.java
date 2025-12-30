package com.eudes.screenmatch.exerciciosStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//2 -Dada a lista de palavras (strings) abaixo, agrupe-as pelo seu tamanho.
//No código a seguir, há um exemplo prático do resultado esperado.
public class Ex002 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        // Resultado Esperado: {4=[java, code], 6=[stream, lambda]}

        Map<Integer, List<String>> agrupados = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupados);
    }
}
