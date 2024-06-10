package com.certidevs.repository;

import com.certidevs.model.Book;
import com.certidevs.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*
Spring Repository Derived Method
MÉTODOS DERIVADOS: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
* Los métodos sin cuerpo, es decir, solamente declarados, son leídos por Spring e implementados automáticamente
* Importate: el nombre debe ser correcto acorde a unas reglas. Usar el plugin JPA Buddy para generarlos.
* Si el método está mal escrito no arranca spring y da un fallo en la consola.

 */
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find Collection: Devuelven múltiples libros en una lista
    List<Book> findByNumPagesLessThan(Integer numPages);
    List<Book> findByNumPagesBetween(Integer numPagesStart, Integer numPagesEnd);
    List<Book> findByTitleContains(String title);
    List<Book> findByAvailableTrue();
    List<Book> findByStatus(Status status);
    List<Book> findByReleaseDateBetween(LocalDate releaseDateStart, LocalDate releaseDateEnd);
    List<Book> findByNumPagesGreaterThanAndPriceLessThanAndAvailableTrue(Integer numPages, Double price);



    // Find instance:
    // Devolver un solo libro: requiere hacer un filtro por el cual no haya más de 1 resultado
    // Filtrar por atributos que den un resultado único, ej: email, isbn, nif, cif, ....
    Book findByTitleIgnoreCase(String title);
    // Cambia el prefijo para no duplicar con el anterior
    Optional<Book> getByTitleIgnoreCase(String title);
    Book findFirstByTitle(String title);

    Book findFirstByPriceNotNullOrderByPriceDesc(); // SELECT * FROM products where price not null order by price desc
    Book findFirstByPriceNotNullOrderByPrice();

    long countByStatus(Status status);

    boolean existsByReleaseDateBefore(LocalDate releaseDate);


}