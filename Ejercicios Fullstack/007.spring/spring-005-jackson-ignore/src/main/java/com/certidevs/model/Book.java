package com.certidevs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String title;
    private Double price;
    private Integer numPages;
    private Boolean available;

    // asociacion ManyToOne con Author
    private Author author;
}
