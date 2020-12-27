package com.restcatapi.rest.model;

import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class CatTemp {
    //private String id;
    private String name;
    private String temperament;
    //private String origin;

    public CatTemp(String name, String temperament){
        this.name = name;
        this.temperament = temperament;
    }
}
