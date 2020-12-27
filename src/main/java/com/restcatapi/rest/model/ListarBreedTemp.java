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
public class ListarBreedTemp {
    private String apiKey = "18329813-e5e3-43b4-8dd6-211b45bd887c";
    private ArrayList<CatTemp> listaTemp = new ArrayList<>();
    private String listaT;

    public ArrayList<CatTemp> tempBreeds(String temp){
        ParseTemp transfTemp = new ParseTemp();
        transfTemp.setTemp(temp);



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.thecatapi.com/v1/breeds"))
                .header("x-api-key", apiKey).build();
        listaT = client.sendAsync(request, HttpResponse.BodyHandlers
        .ofString()).thenApply(HttpResponse::body)
        //.thenApply(ParseTemp::parseTemp)
        //.thenAccept(System.out::println)
        .join();
        listaTemp = transfTemp.parseTemp(listaT); 
        System.out.println(listaTemp);
        return listaTemp;
        }
    }
    

