package com.certidevs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PruebaLogController {


    @GetMapping("prueba")
    public String prueba() {
        log.info("Log nivel info");
        log.warn("Log nivel warning");

        int numero = 2;
        Integer numero2 = 2;

        log.error("El numero obtenido es incorrecto {}", numero);

        return "prueba";
    }
}
