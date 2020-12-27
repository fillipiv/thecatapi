package com.restcatapi.rest.controller;

import java.util.ArrayList;

import com.restcatapi.rest.model.CatOrigin;
import com.restcatapi.rest.model.CatTemp;
import com.restcatapi.rest.model.ConsultaRaca;
import com.restcatapi.rest.model.ListarBreedOrigin;
import com.restcatapi.rest.model.ListarRacaRequest;
import com.restcatapi.rest.model.ListarBreedTemp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/breeds")
public class RestContoller {

    @GetMapping("/all") // Retorna array list de raças obtidas da consulta ao endpoint /breeds
    public ArrayList<String> listBreeds() {
        ListarRacaRequest listBreed = new ListarRacaRequest();
        return listBreed.ListarRacas();
    }

    @GetMapping("/lookup/{id}")
    public String breedDetails(@PathVariable String id) {
        ConsultaRaca consultarRaca = new ConsultaRaca();
        return consultarRaca.consultarRaca(id);
    }

    @GetMapping("/temperament/{temp}")
    public ArrayList<CatTemp> listBreedsByTemp(@PathVariable String temp) {
        ListarBreedTemp listBreedTemp = new ListarBreedTemp();
        return listBreedTemp.tempBreeds(temp);
    }

    @GetMapping("/origin/{origin}")
    public ArrayList<CatOrigin> listBreedsByOrigin(@PathVariable String origin) {
        ListarBreedOrigin listBreedOrigin = new ListarBreedOrigin();
        return listBreedOrigin.originBreeds(origin);
    }
}
