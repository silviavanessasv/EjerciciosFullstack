package com.certidevs.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Clase para representar una Pelicula / Film
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
// JPA
@Entity // Obligatorio
@Table(name = "films") // Opcional
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer durationInMin;

    private LocalDate releaseDate;
    // Asociación: lado owner Many To Many
    // Una película puede tener varias categorías: acción, comedia
    // La categoría comedia puede estar en varias películas a la vez
    @ManyToMany
    @ToString.Exclude // Excluir asociaciones de toString para evitar
    // problemas rendimiento con las consultas
    private List<Category> categories = new ArrayList<>();

}
