package com.certidevs.repository;

import com.certidevs.model.Book;
import com.certidevs.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByBook_IdOrderByIdDesc(Long id);

    @Transactional
    void deleteByBookId(Long bookId);




}