package com.certidevs.controller;

import com.certidevs.model.Author;
import com.certidevs.model.Book;
import com.certidevs.repository.AuthorRepository;
import com.certidevs.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior
@RestController
@AllArgsConstructor
@Slf4j
public class AuthorController {

    private AuthorRepository repo;
    private FileService fileService;

    @GetMapping("authors")
    public List<Author> findAll() {
        return this.repo.findAll();
    }

    @GetMapping("authors/{id}")
    public Author findById(@PathVariable Long id) {
        return this.repo.findById(id).orElseThrow();
    }

    // Extra OPCIONAL: además del CRUD permitimos subir archivos
    // Guardar el archivo y obtener la ruta al archivo y guardar la ruta en photoUrl
    // Nuevo controlador para servir los archivos
    @PostMapping("authors")
    public Author create(
            @RequestParam(value = "photo", required = false) MultipartFile file,
            Author author){

        if(file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            author.setPhotoUrl(fileName);
        } else {
            author.setPhotoUrl("avatar.png");
        }

        return this.repo.save(author);
    }

    @PutMapping("authors/{id}")
    public ResponseEntity<Author> update(
            @PathVariable Long id,
            Author author,
            @RequestParam(value = "photo", required = false) MultipartFile file
    ){
        if(!this.repo.existsById(id))
            return ResponseEntity.notFound().build();

        if(file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            author.setPhotoUrl(fileName);
        }
        return ResponseEntity.ok(this.repo.save(author));
    }
}
