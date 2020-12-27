package com.restcatapi.rest.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/* import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; */

public class ParseTemp {
    private String temp;
    

    public ArrayList<CatTemp> parseTemp(String listaT) {
        String tempLow = temp.toLowerCase();
        JSONArray listaDados = new JSONArray(listaT);
        ArrayList<CatTemp> listaNameTemp = new ArrayList<>();

        for (int i = 0; i < listaDados.length(); i++) {
            JSONObject itemListaDados = listaDados.getJSONObject(i);
            String temperament = itemListaDados.getString("temperament");
            String temperamentLow = temperament.toLowerCase();
            String name = itemListaDados.getString("name");
            
            if (temperamentLow.contains(tempLow)) {
                CatTemp cat = new CatTemp(name, temperament);
                // System.out.println("gato criado: " + cat.getName());
                listaNameTemp.add(cat);
                // System.out.println("gato adicionado: " + cat.getName());
            } /* else {
                System.out.println("temperamento não encontrado para: " + name);
            }   */
        }
        return listaNameTemp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
