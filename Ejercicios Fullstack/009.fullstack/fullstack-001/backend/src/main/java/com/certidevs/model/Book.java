package com.certidevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(unique = true, nullable = false)
    private String isbn;

    private Double price;

    @Column(columnDefinition = "boolean default false")
    private Boolean published;

    private LocalDate releaseDate;

    // @Enumerated(EnumType.ORDINAL) // para mejor rendimiento
    @Enumerated(EnumType.STRING)
    private BookType type;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Editorial editorial;

    // @OneToMany(mappedBy = "book",  cascade = CascadeType.REMOVE)
    // private Set<Rating> ratings = new HashSet();
}
