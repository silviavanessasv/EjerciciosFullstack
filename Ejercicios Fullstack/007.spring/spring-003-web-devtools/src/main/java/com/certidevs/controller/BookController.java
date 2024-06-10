package com.certidevs.controller;

import com.certidevs.model.Author;
import com.certidevs.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController { // Controller o Resource

    // declarar ArrayList de Books
    List<Book> books;

    // constructor: agregar 3 libros al arraylist
    public BookController() {
        books = new ArrayList<>();
        books.add(
                new Book(1L, "Libro1", 19.99, true, new Author(1L, "Author1", "NewYork"))
        );
        books.add(
                new Book(2L, "Libro2", 39.99, false, new Author(1L, "Author1", "NewYork"))
        );
        books.add(
                new Book(3L, "Libro3", 49.99, true, new Author(2L, "Author2", "Asturias"))
        );
    }

    // Métodos GetMapping con ResponseEntity que devuelva una lista de books
    @GetMapping("books")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(this.books);
    }
    // Métodos GetMapping con ResponseEntity que devuelva un book por id filtrando
    @GetMapping("books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        for (Book book: this.books){

            if (book.id().equals(id)) {
                // Si encuentra el book lo devuelve
                return ResponseEntity.ok(book);
            }

        }

        return ResponseEntity.notFound().build();

        // Equivalente en programación funcional:
//        return this.books.stream()
//                .filter(b -> b.id().equals(id)).findFirst()
//                .map(book -> ResponseEntity.ok(book))
//                .orElse(ResponseEntity.notFound().build());

    }

    // Métodos GetMapping con ResponseEntity que devuelva una lista de books por autor
    @GetMapping("books/by-author-id/{authorId}")
    public ResponseEntity<List<Book>> findAllByAuthorId(@PathVariable Long authorId) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : this.books) {
            if(book.author().id().equals(authorId)) {
                filteredBooks.add(book); // Guardo el libro cuyo autor coincide
            }
        }

        if (filteredBooks.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(filteredBooks);
    }

    @PostMapping("books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        if (book.id() != null) // Si viene con id quiere decir que ya existe y por tanto no debe crearse de nuevo
            return ResponseEntity.badRequest().build();

        // TODO generar un nuevo id
        // TODO guardar en base de datos
        // TODO try catch gestionar errores

        this.books.add(book);

        return ResponseEntity.status(201).body(book);

    }

    // PUT para actualizar un libro existente
    @PutMapping("books/{id}")
    public ResponseEntity<Book> update( @RequestBody Book book, @PathVariable Long id) {
        if(id == null || book.id() == null)
            return ResponseEntity.badRequest().build();

        // Opción 1 con for each:
        int index = -1;
        for (Book currentBook: this.books) {
            if (currentBook.id().equals(id)) {
                // detectado libro a modificar
                index = this.books.indexOf(currentBook);
            }
        }
        // Opción 2: con for i
//        for (int i = 0; i < this.books.size(); i++) {
//            if (this.books.get(i).id().equals(id) ){
//                index = i;
//            }
//        }
        // comprobar si se ha encontrado el book, si no se encuentra devolver 404 not found
        if (index == -1)
            return ResponseEntity.notFound().build();

        // Reemplazar un objeto por otro con set
        this.books.set(index, book);
        return ResponseEntity.ok(book);
    }

    // DELETE para borrar un libro existente

    @DeleteMapping("books/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        int index = -1;
        for (Book currentBook: this.books) {
            if (currentBook.id().equals(id)) {
                // detectado libro a modificar
                index = this.books.indexOf(currentBook);
            }
        }

        if (index == -1) // no se ha encontrado
            return ResponseEntity.notFound().build();

        this.books.remove(index);

        return ResponseEntity.noContent().build(); // http status 204: el contenido ha sido eliminado correctamente
    }

    // DELETE para borrar todos

    @DeleteMapping("books")
    public ResponseEntity<Void> deleteAll() {
        this.books.clear();
        return ResponseEntity.noContent().build();
    }


}
