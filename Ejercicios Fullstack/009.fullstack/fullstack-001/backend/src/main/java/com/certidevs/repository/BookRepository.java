package com.certidevs.repository;

import com.certidevs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);


    // Para filtrar libros por autor
    List<Book> findAllByAuthor_Id(Long id);
    List<Book> findByPublishedTrue();



}