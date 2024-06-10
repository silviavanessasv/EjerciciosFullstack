package com.certidevs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 13)
    private String isbn;

    private String title;

    @Column(name = "num_pages")
    private Integer numPages;

    private Double price;

    @ManyToOne // Asociación clave foránea con Author
    private Author author;

    /*
    IMPORTANTE: no ponemos asociaciones en toString para evitar problemas con
    las consultas LAZY, esto significa que si el Book no trae Author daría problemas al intentar imprimir el autor
    dentro del tostring de book
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", numPages=" + numPages +
                ", price=" + price +
                '}';
    }
}
