package com.restcatapi.rest.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.ArrayList;

public class ConsultaRaca {
    private static String apiKey = "18329813-e5e3-43b4-8dd6-211b45bd887c";
    //private static ArrayList<String> listaDetalhes = new ArrayList<>();
    private String detalhes;

    public String consultarRaca(String id) {
        HttpClient clientLista = HttpClient.newHttpClient();
        HttpRequest requestLista = HttpRequest
                .newBuilder(URI.create("https://api.thecatapi.com/v1/breeds/search?q=" + id))
                .header("x-api-key", apiKey).build();
        detalhes = clientLista.sendAsync(requestLista, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenApply(ParseDetail::parseDetail)
                // .thenAccept(System.out::println)
                .join();
        System.out.println(detalhes);
        return detalhes;
    }
}
