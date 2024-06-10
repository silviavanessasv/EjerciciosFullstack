package com.certidevs.controller;

import com.certidevs.exception.ConflictDeleteException;
import com.certidevs.model.Book;
import com.certidevs.model.Reservation;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.BookRepository;
import com.certidevs.repository.RatingRepository;
import com.certidevs.repository.ReservationRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior
@RestController
@AllArgsConstructor
@Slf4j
public class BookController {

    private final BookRepository repo;
    private final RatingRepository ratingRepo;
    private final ReservationRepository reservationRepo;

    @GetMapping("books")
    public List<Book> findAll() {
        log.info("REST request to findAll books");

        User user = SecurityUtils.getCurrentUser().orElseThrow();

        if(user.getRole().equals(Role.ADMIN))
            return this.repo.findAll();
        else
            return this.repo.findByPublishedTrue();

    }

    @GetMapping("books/{id}")
    public Book findById(@PathVariable Long id) {
        return this.repo.findById(id).orElseThrow();
    }

    //obtener libros filtrando por autor
    @GetMapping("books/filter-by-author/{id}")
    public List<Book> findAllByAuthorId(@PathVariable Long id) {
        return this.repo.findAllByAuthor_Id(id);
    }


    @PostMapping("books")
    public Book create(@RequestBody() Book book) {
        return this.repo.save(book);
    }

    @PutMapping("books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        if(this.repo.existsById(id))
            return this.repo.save(book);

        throw new NoSuchElementException();
    }

    @DeleteMapping("books/{id}")
    public void deleteById(@PathVariable Long id) {
//        // Opción 1: borrar el libro, pero antes desasociar o borrar aquellos objetos que apunten al book
//        try {
//            this.ratingRepo.deleteByBookId(id);
//            this.reservationRepo.deleteByBookId(id);
//            this.repo.deleteById(id);
//        } catch (Exception e) {
//            log.error("Error borrando Book", e);
//            throw new ConflictDeleteException("No es posible borrar el libro.");
//        }


        // OPción 2: desactivar/archivar el libro
        Book book = this.repo.findById(id).orElseThrow();
        book.setPublished(false);
        repo.save(book);
    }
}
