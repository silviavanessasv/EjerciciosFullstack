package com.certidevs.repository;

import com.certidevs.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional poner la anotación @Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}