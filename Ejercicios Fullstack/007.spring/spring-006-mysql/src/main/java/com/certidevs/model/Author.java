package com.certidevs.model;

import jakarta.persistence.*; // JPA
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // Determina que se almacena en base de datos como una tabla
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50) // nombre obligatorio
    private String name;

    // Esta anotación es opcional y sirve para configurar la columna
    @Column(unique = true) // email unique
    private String email;

    private Double salary;

    private Boolean active;

    private LocalDate birthday;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", birthday=" + birthday +
                '}';
    }
}
