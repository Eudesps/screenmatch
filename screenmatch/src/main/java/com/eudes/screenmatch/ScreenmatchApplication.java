package com.eudes.screenmatch;

import com.eudes.screenmatch.models.DadosEpisodio;
import com.eudes.screenmatch.models.DadosSerie;
import com.eudes.screenmatch.models.DadosTemporada;
import com.eudes.screenmatch.service.ConsumoApi;
import com.eudes.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        ConverteDados converte = new ConverteDados();

        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=f5fb160b");
        System.out.println(json);

        DadosSerie serie = converte.converteDados(json, DadosSerie.class);
        System.out.println(serie);

        json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=f5fb160b");
        DadosEpisodio dadosEpisodio = converte.converteDados(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);

        List<DadosTemporada> dadosTemporadasList = new ArrayList<>();
        for(int i = 1; i <= serie.totalTemporadas(); i++){
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+i+"&apikey=f5fb160b");
            DadosTemporada dadosTemporada = converte.converteDados(json, DadosTemporada.class);
            dadosTemporadasList.add(dadosTemporada);
        }
        dadosTemporadasList.forEach(System.out::println);
    }
}
