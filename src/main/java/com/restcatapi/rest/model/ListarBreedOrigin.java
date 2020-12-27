package com.restcatapi.rest.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter @Setter //@NoArgsConstructor
public class ListarBreedOrigin {
    private String apiKey = "18329813-e5e3-43b4-8dd6-211b45bd887c";
    private ArrayList<CatOrigin> listaOrigin = new ArrayList<>();
    private String listaO;

    public ArrayList<CatOrigin> originBreeds(String origin){
        ParseOrigin transfOrigin = new ParseOrigin();
        transfOrigin.setOrigin(origin);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.thecatapi.com/v1/breeds"))
                .header("x-api-key", apiKey).build();
        listaO = client.sendAsync(request, HttpResponse.BodyHandlers
        .ofString()).thenApply(HttpResponse::body)
        //.thenApply(ParseTemp::parseTemp)
        //.thenAccept(System.out::println)
        .join();
        listaOrigin = transfOrigin.parseTemp(listaO); 
        System.out.println(listaOrigin);
        return listaOrigin;
        }
    }
    

