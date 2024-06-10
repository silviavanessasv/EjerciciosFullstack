package com.certidevs.proyecto4;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;

    private LocalDateTime dateHour; // SE puede obtener de fusionar el dia y hora seleccionado por usuario en Availibity
    private AppointStatus status; // disponible, reservada, cancelada

    private User patient;
    // private User professional;

    private Treatment treatment;
    private OfficeCenter center;
}
