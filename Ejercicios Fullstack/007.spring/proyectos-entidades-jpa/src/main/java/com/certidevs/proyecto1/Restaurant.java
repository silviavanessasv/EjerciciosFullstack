package com.certidevs.proyecto1;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private Long id;
    private String name;
    private String cif;
    private String phone;
    private String email;
    private Boolean hasTerrace;
    private Boolean hasDelivery;

    // se pueden extraer a una nueva entidad Address a futuro
    private String street;
    private String city;
    private String postalCode;

    // El restaurante puede servir comida de varios tipos: japonés, vietnamita, español...
    // Asociación @ManyToMany
    // @JsonIgnoreProperties()
    private List<Category> categories = new ArrayList<>();


}
