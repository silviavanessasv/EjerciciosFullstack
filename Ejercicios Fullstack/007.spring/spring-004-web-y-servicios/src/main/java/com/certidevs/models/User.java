package com.certidevs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase User con anotaciones Lombok que autogeneran
 * los métodos constructores, getter, setter, toString, etc
 *
 * Además, tiene método builder para construir los objetos
 * de forma más dinámica utilizando encadenamiento de métodos
 * y un método .build()
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    // no mostrar password en las respuestas JSON, es un dato sensible
    @JsonIgnore
    private String password;

}
