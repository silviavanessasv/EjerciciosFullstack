package com.certidevs;

import com.certidevs.model.*;
import com.certidevs.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		/*
		Insertar datos demo desde aquí.
		NO insertarlos directamente en MySQL Workbench manualmente para evitar que Hibernate no los detecte.

		EN PRODUCCIÓN NO SE INSERTARÍAN DATOS DEMO ASÍ NI SE BORRARÍAN LOS DATOS ACTUALES.
		En producción se suele utilizar un framework de control de versiones sobre la base de datos
		como por ejemplo: liquibase o flyway
		 */
		BookRepository bookRepository = context.getBean(BookRepository.class);
		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
		EditorialRepository editorialRepository = context.getBean(EditorialRepository.class);
		RatingRepository ratingRepository = context.getBean(RatingRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		ReservationRepository reservationRepository = context.getBean(ReservationRepository.class);

		// Primero se borran los libros porque tienen asociaciones hacia author y editorial
		// si borras primero un author o editorial dará error al haber libros apuntando a ellos
		reservationRepository.deleteAll();
		ratingRepository.deleteAll();
		bookRepository.deleteAll();
		editorialRepository.deleteAll();
		authorRepository.deleteAll();
		userRepository.deleteAll();


		Author a1 = new Author(null, "author1", "españa", true, "https://placehold.co/400", "Texto largo de leer");
		Author a2 = new Author(null, "author2", "brasil", true, "https://placehold.co/400", "Texto largo de leer");
		Author a3 = new Author(null, "author3", "italia", true,"https://placehold.co/400", "Texto largo de leer");
		authorRepository.saveAll(List.of(a1, a2, a3));

		Editorial e1 = new Editorial(null, "Editorial 1", "https://picsum.photos/id/944/900/500", "descripcion larga", 2019);
		Editorial e2 = new Editorial(null, "Editorial 2", "https://picsum.photos/id/1011/900/500", "descripcion larga", 2021);
		Editorial e3 = new Editorial(null, "Editorial 3", "https://picsum.photos/id/984/900/500", "descripcion larga", 2023);
		editorialRepository.saveAll(List.of(e1, e2, e3));


		Book b1 = new Book(null, "Libro 1", "1111", 19.99, true, LocalDate.now(), BookType.SOFT_COVER, a1, e1);
		bookRepository.save(b1);
		bookRepository.save(new Book(null, "Libro 2", "2222", 22.99, false, LocalDate.now(), BookType.HARD_COVER, a1, e1));
		bookRepository.save(new Book(null, "Libro 3", "3333", 25.99, true, LocalDate.now(), BookType.EBOOK, a2, e2));
		bookRepository.save(new Book(null, "Libro 4", "4444", 29.99, false, LocalDate.now(), BookType.AUDIO_BOOK, a3, e3));

		Rating r1 = new Rating(null, 0, "Libro fantástico", b1, null);
		Rating r2 = new Rating(null, 2, "Libro muy largo y pesado de leer", b1, null);
		Rating r3 = new Rating(null, 5, "Libro interesante", b1, null);
		ratingRepository.saveAll(List.of(r1, r2, r3));

		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		User u1 = User.builder()
				.email("admin@gmail.com")
				.name("admin")
				.password(passwordEncoder.encode("admin1234"))
				.role(Role.ADMIN)
				.build();

		User u2 = User.builder()
				.email("user@gmail.com")
				.name("user")
				.password(passwordEncoder.encode("user1234"))
				//.password("$2a$10$pvALtjqAoNtSOg4AKLZhkO6Un6wFe.KahT/cScqKKABFTAiEsB1rq")
				.role(Role.USER)
				.build();

		userRepository.saveAll(List.of(u1, u2));

	}

}
