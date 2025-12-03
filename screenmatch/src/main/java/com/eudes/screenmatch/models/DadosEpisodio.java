package com.eudes.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String title,
                            @JsonAlias("imdbRating") String avaliacao,
                            @JsonAlias("Episode") Integer  numeroEpisodio,
                            @JsonAlias("Released") String dataLancamento) {
}
