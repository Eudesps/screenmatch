package com.eudes.screenmatch;

import com.eudes.screenmatch.models.DadosSerie;
import com.eudes.screenmatch.service.ConsumoApi;
import com.eudes.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    }
}
