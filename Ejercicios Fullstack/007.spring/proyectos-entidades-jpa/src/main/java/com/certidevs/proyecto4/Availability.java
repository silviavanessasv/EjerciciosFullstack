package com.certidevs.proyecto4;

import java.time.LocalDate;
import java.time.LocalTime;

// Entidad soporte con información de tiempo para lograr que el usuario complete
// un Appointment (una cita)
public class Availability {

    private Long id;

    private LocalDate date; // se utiliza para filtrar fecha y dia
    private LocalTime startTime;
    private AppointDuration duration; // 30 O 60

    private OfficeCenter center;
    private Treatment treatment;
}
