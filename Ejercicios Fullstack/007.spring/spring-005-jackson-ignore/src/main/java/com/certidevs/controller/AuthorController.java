package com.certidevs.controller;

import com.certidevs.model.Author;
import com.certidevs.model.Book;
import org.slf4j.Logger; // import para logs
import org.slf4j.LoggerFactory; // import para logs
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {

    private final Logger log = LoggerFactory.getLogger(AuthorController.class);

    @GetMapping("author")
    public Author findAuthor(){
        // 2024-02-05T16:01:27.159+01:00  INFO 33092 --- [nio-8080-exec-2] c.certidevs.controller.AuthorController  : Petición REST a findAuthor
        log.info("Petición REST a findAuthor");
        log.warn("Esto es un warning");
        log.error("Esto es un error");
        // El sout normal no muestra tanta información:
        System.out.println("Petición REST a findAuthor");

        // PASO 1: CREAR UN BOOK
        Book book1 = new Book();
        book1.setId(1L);
        // book1.setAuthor("Cervantes"); // String
        // book1.setAuthor(author);

        // PASO 2: CREAR UN AUTHOR
         Author author = new Author();
         author.setId(1L);
         author.setName("a1");
//        Author author = Author.builder().id(1L).name("Author").build();

        // PASO 3: ASIGNAR BOOK A AUTHOR
        // if (author.getBooks() == null)
        //    author.setBooks(new ArrayList<>());
        author.getBooks().add(book1);

        // PASO 4: ASIGNAR AUTHOR A BOOK
        book1.setAuthor(author); // objeto Author

        return author;
    }
}
