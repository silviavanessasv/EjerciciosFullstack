package com.certidevs.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer numPages;

    private Double price;

    private Boolean available;

    // Enumeración: la guardamos como un string para evitar que sea tinyint y haya problemas
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate releaseDate;


}
