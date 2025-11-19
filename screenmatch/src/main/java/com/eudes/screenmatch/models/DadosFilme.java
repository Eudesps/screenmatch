package com.eudes.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosFilme(@JsonAlias("Title") String titulo,
                         @JsonAlias("totaleSeasons") Integer totalTemporadas,
                         @JsonAlias("omdbRationg") String avaliacao,
                         @JsonAlias("omdbVotes") String votos) {
}
