package com.eudes.screenmatch.principal;

import com.eudes.screenmatch.models.DadosSerie;
import com.eudes.screenmatch.models.DadosTemporada;
import com.eudes.screenmatch.service.ConsumoApi;
import com.eudes.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private  final String API_KEY = "&apikey=f5fb160b";

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private  ConverteDados converte = new ConverteDados();

    private String nomeSerie = "".replace(" ", "+");

    public void exibirMenu(){
        System.out.println("DIGITE O NOME DA SÉRIE PARA PESQUISA -> ");
        nomeSerie = scanner.next();

        //DADOS SÉRIE
        var json = consumoApi.obterDados(ENDERECO+nomeSerie+API_KEY);
        DadosSerie serie = converte.converteDados(json, DadosSerie.class);
        System.out.println(serie);

       //DADOS TEMPORADA
        List<DadosTemporada> dadosTemporadasList = new ArrayList<>();
        for(int i = 1; i <= serie.totalTemporadas(); i++){
            json = consumoApi.obterDados(ENDERECO + nomeSerie + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converte.converteDados(json, DadosTemporada.class);
            dadosTemporadasList.add(dadosTemporada);
        }
        dadosTemporadasList.forEach(System.out::println);
    }
}
