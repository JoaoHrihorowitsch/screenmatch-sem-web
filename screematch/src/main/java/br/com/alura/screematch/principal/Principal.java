package br.com.alura.screematch.principal;

import br.com.alura.screematch.model.DadosSerie;
import br.com.alura.screematch.model.DadosTempoda;
import br.com.alura.screematch.service.ConsumoAPI;
import br.com.alura.screematch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scan = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERCO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=9f78f39";

    public void exibeMenu(){
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Buscar série");
        System.out.println("2 - Sair");
        int opcao = scan.nextInt();
        scan.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome da Série:");
                var nomeSerie = scan.nextLine();

                var json = consumo.obterDados(ENDERCO + nomeSerie.replace(" ", "+") + API_KEY);

                DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
                System.out.println(dados);

                List<DadosTempoda> temporadas = new ArrayList<>();

                for(int i=1; i<= dados.totalTemporadas(); i++){
                    json = consumo.obterDados(ENDERCO + nomeSerie.replace(" ", "+") + "&season=" + i +  API_KEY);
                    DadosTempoda temporada = conversor.obterDados(json, DadosTempoda.class);
                    temporadas.add(temporada);
                }

                temporadas.forEach(t -> {
                    System.out.println("temporada " + t.temporada() + ":");
                    t.episodioList().forEach(e -> System.out.println(e.titulo() + " - " + e.titulo()));
                    System.out.println();
                });
                break;

            case 2:
                System.out.println("Encerrando progama...");
                break;
        }
    }
}
