package com.certidevs.controller;

import com.certidevs.model.Reservation;
import com.certidevs.repository.ReservationRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior
@RestController
@AllArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationRepository repo;


    @PostMapping("reservations")
    public Reservation create(@RequestBody Reservation reservation){
        SecurityUtils.getCurrentUser().ifPresent(user -> reservation.setUser(user));
        return this.repo.save(reservation);
    }

}
