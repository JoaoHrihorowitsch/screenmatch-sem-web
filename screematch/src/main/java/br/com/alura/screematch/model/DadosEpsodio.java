package br.com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodio(@JsonAlias("Title") String titulo,
                           @JsonAlias("Episode") Integer numeroEpdosio,
                           @JsonAlias("imdbRating") String avaliacao,
                           @JsonAlias("Released") String dataLancamento){
}
