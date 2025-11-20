package com.eudes.screenmatch.principal;

import com.eudes.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private  final String API_KEY = "&apikey=f5fb160b";

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();

    public void exibirMenu(){
        System.out.println("DIGITE O NOME DA SÉRIE PARA PESQUISA -> ");
        var nomeSerie = scanner.next();
        var json = consumoApi.obterDados(ENDERECO+nomeSerie+API_KEY);
    }
}
