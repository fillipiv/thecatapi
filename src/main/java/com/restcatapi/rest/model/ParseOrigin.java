package com.restcatapi.rest.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseOrigin {
    private String origin;
    

    public ArrayList<CatOrigin> parseTemp(String listaO) {
        String tempOrigin = origin.toLowerCase();
        JSONArray listaDados = new JSONArray(listaO);
        ArrayList<CatOrigin> listaNameOrigin = new ArrayList<>();

        for (int i = 0; i < listaDados.length(); i++) {
            JSONObject itemListaDados = listaDados.getJSONObject(i);
            String origin = itemListaDados.getString("origin");
            String originLow = origin.toLowerCase();
            String name = itemListaDados.getString("name");
            
            if (originLow.contains(tempOrigin)) {
                CatOrigin cat = new CatOrigin(name, origin);
                // System.out.println("gato criado: " + cat.getName());
                listaNameOrigin.add(cat);
                // System.out.println("gato adicionado: " + cat.getName());
            } /* else {
                System.out.println("temperamento não encontrado para: " + name);
            }   */
        }
        return listaNameOrigin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
