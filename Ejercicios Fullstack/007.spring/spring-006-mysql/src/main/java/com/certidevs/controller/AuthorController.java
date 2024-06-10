package com.certidevs.controller;

import com.certidevs.model.Author;
import com.certidevs.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AuthorController {

    private AuthorRepository repo;

    @GetMapping("authors")
    public List<Author> findAll() {
        return repo.findAll();
    }

    // recuperar author por id
    @GetMapping("authors/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        Optional<Author> authorOpt = repo.findById(id);

        if (authorOpt.isPresent())
            return ResponseEntity.ok(authorOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("authors")
    public ResponseEntity<Author> create(@RequestBody Author author) {
        return ResponseEntity.ok(repo.save(author));
    }

    // Actualizar un autor existente en base de datos

    @PutMapping("authors/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id,
                                         @RequestBody Author author) {

        // Opción 1: se guarda tal cual y esto permitiría modificar todos los atributos
        //if(!repo.existsById(id))
        //    return ResponseEntity.notFound().build();
        // return ResponseEntity.ok(repo.save(author));

        // Opción 2: solo permitimos modificar ALGUNOS atributos: active, salary
        Optional<Author> authorOptional = repo.findById(id);

        if(authorOptional.isEmpty()) // Si isEmpty significa que no existe y por tanto devolvemos 404 not found
            return ResponseEntity.notFound().build();

        Author authorFromDB = authorOptional.get();

        authorFromDB.setActive(author.getActive());
        authorFromDB.setSalary(author.getSalary());

        return ResponseEntity.ok(repo.save(authorFromDB));
    }

    // borrar un author por un id
    @DeleteMapping("authors/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { // no recibe ningún objeto por JSON
        // SE puede agregar un repo.existsById(id)
        repo.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }

}
