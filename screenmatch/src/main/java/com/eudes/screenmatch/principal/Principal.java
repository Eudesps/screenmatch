package com.eudes.screenmatch.principal;

import com.eudes.screenmatch.models.DadosEpisodio;
import com.eudes.screenmatch.models.DadosSerie;
import com.eudes.screenmatch.models.DadosTemporada;
import com.eudes.screenmatch.models.Episodios;
import com.eudes.screenmatch.service.ConsumoApi;
import com.eudes.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

       //DADOS TEMPORADA
        List<DadosTemporada> dadosTemporadasList = new ArrayList<>();
        for(int i = 1; i <= serie.totalTemporadas(); i++){
            json = consumoApi.obterDados(ENDERECO + nomeSerie + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = converte.converteDados(json, DadosTemporada.class);
            dadosTemporadasList.add(dadosTemporada);
        }
        //dadosTemporadasList.forEach(System.out::println);

        //Foi dado um forEach na lista de temporadas, pegado as temporadas, foi dado um outro forEach para
        //cada episódio para poder imprimir o nome de cada um.
        dadosTemporadasList.forEach(t -> t.episodiosList().forEach(e -> System.out.println(e.title())));

        List<DadosEpisodio> dadosEpisodios = dadosTemporadasList.stream()
                .flatMap(t -> t.episodiosList().stream())
                .collect(Collectors.toList());

        System.out.println("/n TOP 5 EPISÓDIOS");
        dadosEpisodios.stream()
            .filter(e -> !e.avaliacao().equals("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        //Aqui vai ser listado todos os episódios e criar uma instância da classe Episodios e passar para uma lista
        //do tipo Episodios. Além de passar os episódios ele vai também o número da temporada que o episódio está atrelado.
        List<Episodios> episodios = dadosTemporadasList.stream()
                .flatMap(e -> e.episodiosList().stream()
                        .map(d -> new Episodios(e.numeroTemporada(), d)))
                .toList();


        System.out.println("A partir de que ano você gostaria de ver os episodios? ");
        var ano = scanner.nextInt();
        scanner.nextLine();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataBusca = LocalDate.of(ano, 1,1);
        episodios.stream()
                        .filter(e -> e.getDataLancamento()!= null && e.getDataLancamento().isAfter(dataBusca))
                                .forEach(e -> System.out.println(
                                        "Temporda: " + e.getTemporada() +
                                                "Nome Episodio: " + e.getTitulo() +
                                        "Data de Lançamento: " + e.getDataLancamento().format(f)
                                ));

        //episodios.forEach(System.out::println);
    }
}
