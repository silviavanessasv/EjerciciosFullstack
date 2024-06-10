package com.certidevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Clase de prueba para hacer una asociacion
 * de tipo One To One con Address
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    // ASociación One To One : lado owner
    // Un usuario tiene un Address y ese Address solamente lo
    // tiene ese usuario y ninguno más
    @OneToOne
    // @OneToOne(cascade = CascadeType.ALL) // La operación en cascada permite que se cree un nuevo Address automáticamente al crear un usuario
    @JoinColumn(name = "address_id", unique = true) // único para One To One
    private Address address;

}
