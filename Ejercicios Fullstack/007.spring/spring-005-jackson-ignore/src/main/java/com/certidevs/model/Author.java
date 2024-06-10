package com.certidevs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    private Long id;
    private String name;
    private String bio;
    private LocalDate startDate;

    // Asociacion OneToMany con Book
    @JsonIgnoreProperties({"author"}) // IMPORTANTE: ignorar author para evitar StackOverFlowException al parsear a JSON
    private List<Book> books = new ArrayList<>();// IMPORTANTE: inicializar la lista para que no sea null y facilitar a quien la use poder agregar objetos



}
