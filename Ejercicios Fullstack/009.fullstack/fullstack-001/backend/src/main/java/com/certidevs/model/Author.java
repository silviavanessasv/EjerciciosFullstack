package com.certidevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String country;

    // https://www.bennadel.com/blog/3845-why-i-use-tinyint-columns-instead-of-bit-columns-for-boolean-data-in-a-mysql-application.htm
    @Column(columnDefinition = "boolean") // tinyint en lugar de bit
    private Boolean active;

    private String photoUrl;

    @Column(length = 1000) // ampliar la longitud de 255 a 1000
    private String bio;
}
