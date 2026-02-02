package br.com.alura.screenmatch.exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1 - Imagine que você tem uma lista de strings. Algumas das strings são números,
mas outras não. Queremos converter a lista de strings para uma lista de números.
Se a conversão falhar, você deve ignorar o valor. Por exemplo, na lista a seguir,
a saída deve ser [10, 20]:
*/

public class Ex001 {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            try {
                numeros.add(Integer.valueOf(input.get(i)));
            }catch (NumberFormatException e){
                continue;
            }
        }

        System.out.println(numeros);

    }
}
