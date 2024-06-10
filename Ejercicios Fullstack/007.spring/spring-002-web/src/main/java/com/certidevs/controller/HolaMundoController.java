package com.certidevs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/") // En Chrome/Firefox/Edge: http://localhost:8080/
    public String holaMundo() {
        return "Hola mundo que tal";
    }

    @GetMapping("/productos") // En Chrome/Firefox/Edge: http://localhost:8080/productos
    public String productos () {
        return "<h1> Hola mundo </h1>";
    }

}
