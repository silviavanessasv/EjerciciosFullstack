package com.certidevs.controller;

import com.certidevs.model.Film;
import com.certidevs.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class FilmController {

    // final hace que una vez asignado el repository no se pueda cambiar
    private final FilmRepository filmRepository;

    // find all
    @GetMapping("films")
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @PostMapping("films")
    public Film create(@RequestBody Film film) {
        return filmRepository.save(film);
    }
    @PutMapping("films/{id}")
    public Film update(@RequestBody Film film, @PathVariable Long id) {
        return filmRepository.save(film);
    }
    // create: verificar asociacion y desasociacion
    // update


}
