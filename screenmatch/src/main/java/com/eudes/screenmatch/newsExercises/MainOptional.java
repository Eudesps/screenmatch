package com.eudes.screenmatch.newsExercises;

import java.util.Optional;

public class MainOptional {
    public static void main(String[] args) {
        //FORMAS DE LIDAR COM O APTIONAL
        //Optional<String> optional = Optional.empty();
        //Optional<String> optional = Optional.of("Valor");
        Optional<String> optional = Optional.ofNullable(null); // Esse aceita um valor nulo sendo passado.
    }
}
