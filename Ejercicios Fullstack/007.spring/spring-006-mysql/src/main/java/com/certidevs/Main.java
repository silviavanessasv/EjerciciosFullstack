package com.certidevs;

import com.certidevs.model.*;
import com.certidevs.repository.*;
import org.hibernate.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        AuthorRepository repo = context.getBean(AuthorRepository.class);

        // CRUD: CREATE y UPDATE con el método save()
        Author mike = new Author(null, "Mike", "mike@gmail.com", 10000.0, true, LocalDate.now());
        Author bob = new Author(null, "Bob", "Bob@gmail.com", 15000.0, true, LocalDate.now());
        Author alan = new Author(null, "Alan", "Alan@gmail.com", 15000.0, true, LocalDate.now());
        repo.save(mike);
        repo.save(bob);
        repo.save(alan);

        // CRUD: RETRIEVE de todos los datos con findAll sin filtro
        List<Author> authors = repo.findAll();
        System.out.println(authors);

        // CRUD: RETRIEVE un solo autor por su clave primaria

            // Opción 1: extraer del Optional utilizando get()
        Optional<Author> authorOptional = repo.findById(99L);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            System.out.println(author);
        } else {
            System.out.println("No se ha encontrado el autor");
        }
            // Opción 2: extraer el Optional utilizando el orElseThrow
        // Author author1 = authorOptional.orElseThrow();

        // CRUD: DELETE con deleteById para borrar un author
        //repo.deleteById(1L);
        //repo.deleteById(1L); // la segunda no tiene efecto porque ya se ha borrado

        System.out.println(repo.findAll());

        // PROBAR LA ASOCIACION MANY TO MANY
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

        Category accion = new Category(null, "Acción", 16);
        Category comedia = new Category(null, "Comedia", 7);
        Category sciFi = new Category(null, "Science Fiction", 13);
        // Guardar objetos a la vez:
        categoryRepository.saveAll(List.of(accion, comedia, sciFi));

        FilmRepository filmRepo = context.getBean(FilmRepository.class);
        Film peli1 = new Film();
        peli1.setTitle("Película 1");
        peli1.setDurationInMin(150);
        peli1.setReleaseDate(LocalDate.now());
        peli1.getCategories().add(accion); // ASociar categoria
        peli1.getCategories().add(comedia); // Asociar categoria
        peli1.getCategories().add(sciFi); // Asociar categoria
        filmRepo.save(peli1);

        Film peli2 = new Film();
        peli2.setTitle("Película 2");
        peli2.setDurationInMin(150);
        peli2.setReleaseDate(LocalDate.now());
        peli2.getCategories().add(sciFi);
        peli2.getCategories().add(comedia);
        filmRepo.save(peli2);

        // PROBAR LA ASOCIACIÓN DE ONE TO ONE
        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        Address ad1 = new Address(null, "Calle falsa", "Madrid");
        Address ad2 = new Address(null, "Calle prueba", "Madrid");
        Address ad3 = new Address(null, "Calle verdadera", "Madrid");
        Address ad4 = new Address(null, "Calle cuatro", "Madrid");
        addressRepository.saveAll(List.of(ad1, ad2, ad3, ad4));

        UserRepository userRepository = context.getBean(UserRepository.class);
        User user1 = new User(null, "u1@gmail.com", "admin", ad1);
        User user2 = new User(null, "u2@gmail.com", "admin", ad2);
        User user3 = new User(null, "u3@gmail.com", "admin", ad3);
        userRepository.saveAll(List.of(user1, user2, user3));

        // PROBAR LA ASOCIACIÓN MANY TO ONE

    }

}
