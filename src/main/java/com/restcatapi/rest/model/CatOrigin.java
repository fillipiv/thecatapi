package com.restcatapi.rest.model;

import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class CatOrigin {
    //private String id;
    private String name;
    //private String temperament;
    private String origin;

    public CatOrigin(String name, String origin){
        this.name = name;
        this.origin = origin;
    }
}
