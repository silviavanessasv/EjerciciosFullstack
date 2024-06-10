package com.certidevs.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
// JPA
@Entity // Obligatorio
@Table(name = "categories") // Opcional
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer minAge;


}
