package com.restcatapi.rest.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.ArrayList;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ListarRacaRequest {
    private static String apiKey = "18329813-e5e3-43b4-8dd6-211b45bd887c";
    private static ArrayList<String> listaDetalhes = new ArrayList<>();
    //private String teste;

    public ArrayList<String> ListarRacas(){
    // obter lista id das racas
    HttpClient clientLista = HttpClient.newHttpClient();
    HttpRequest requestLista = HttpRequest.newBuilder(URI.create("https://api.thecatapi.com/v1/breeds"))
            .header("x-api-key", apiKey).build();
    listaDetalhes = clientLista.sendAsync(requestLista, HttpResponse.BodyHandlers
    .ofString()).thenApply(HttpResponse::body)
    .thenApply(ParseRaca::parseBreeds)
    //.thenAccept(System.out::println)
    .join();
    System.out.println(listaDetalhes);
    return listaDetalhes;
    }
}
