package com.certidevs.proyecto1;

public class Dish {

    private Long id;

    private String title;
    private String description;

    private Double price;

    private Boolean glutenFree;
    // si es vegano
    // si es frio o caliente
    // dulce o salado
    // alergias String o una entidad separada

    // Many To One
    // A futuro una alternativa es asociarlo a Menu, y Menú a restaurante
    private Restaurant restaurant;


}
