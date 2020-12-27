package com.restcatapi.rest.model;

import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONArray;

public class ParseDetail {

    public static ArrayList<String> parseDetail(String responseBody) {

        //Cat cat = new Cat();
        JSONArray listaDados = new JSONArray(responseBody);
        ArrayList<String> listaRacas = new ArrayList<>();

        for (int i = 0; i < listaDados.length(); i++) {
            JSONObject itemListaDados = listaDados.getJSONObject(i);
            String name = itemListaDados.getString("name");
            listaRacas.add(name);
        }
        return listaRacas;
    }
}