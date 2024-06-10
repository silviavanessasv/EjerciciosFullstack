package com.certidevs.proyecto1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// entidad intermedia entre usuario y restaurante
public class Booking {

    private Long id;

    private LocalDateTime date;

    private Integer numUsers;

    private String observations;

    private Double discount;

    private Boolean interior;

    private String status; // mejor una enum: PENDIENTE, CONFIRMADO, CANCELADO, RECHAZADO

    private Double totalPrice;

    private Integer numTable;

    // @ManyToOne
    private User user;

    // @ManyToOne
    private Restaurant restaurant;

    // @ManyToMany
    private List<Dish> dishes = new ArrayList<>();
}
