package com.eudes.screenmatch.newsExercises;

import java.util.Optional;

public class MainOptional {
    public static void main(String[] args) {
        //FORMAS DE LIDAR COM O APTIONAL
        //Optional<String> optional = Optional.empty();
        //Optional<String> optional = Optional.of("Valor");

        //Se não se tem certeza se o valor é null ou não, é interessante usar o ofNullable
        Optional<String> optional = Optional.ofNullable(null); // Esse aceita um valor nulo sendo passado.

        optional.ifPresentOrElse(op -> System.out.println(op), () -> System.out.println("Não existe valor"));

        /*
        if (optional.isPresent()) {
            System.out.println("Existe Valor: " + optional.get());
        } else {
            System.out.println("Não existe valor");
        }*/
    }
}
