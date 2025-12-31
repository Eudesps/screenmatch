package com.eudes.screenmatch.exerciciosStreams.listaAdicional;

import com.eudes.screenmatch.exerciciosStreams.listaAdicional.models.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        //6 - Dada a lista de produtos acima, agrupe-os por categoria em um Map<String, List<Produto>>.
        Map<String, List<Produto>> agrupadosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        //System.out.println("Móveis: " + agrupadosPorCategoria.get("Móveis"));
        //System.out.println("Eletrônicos: " + agrupadosPorCategoria.get("Eletrônicos"));

        //------------------------------------------------------------------------------------
        //7 - Dada a lista de produtos acima, conte quantos produtos há em cada categoria
        // e armazene em um Map<String, Long>.
        Map<String, Long> qtdProdutosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));

        //System.out.println(qtdProdutosPorCategoria);

        //------------------------------------------------------------------------------------
        //8 - Dada a lista de produtos acima, encontre o produto mais caro de cada
        // categoria e armazene o resultado em um Map<String, Optional<Produto>>.
        Map<String, Optional<Produto>> maiorPrecoPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));

        System.out.println(maiorPrecoPorCategoria);
    }
}
