package com.certidevs.proyecto4;


import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Treatment {

    private Long id;
    private String nombre;
    private String descriptionShort; // summary
    private String descriptionLong;
    private String requirements;
    private String aftercare; // cuidados posteriores.
    private Integer durationInMin;
    private Double price;


    // ManyToMany
    private List<OfficeCenter> offices = new ArrayList<>();
    private Category category;
    private User professional;

}
