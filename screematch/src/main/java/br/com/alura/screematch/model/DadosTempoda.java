package br.com.alura.screematch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTempoda(@JsonAlias("Season") Integer temporada,
                           @JsonAlias("Episodes") List<DadosEpsodio> episodioList) {
}
