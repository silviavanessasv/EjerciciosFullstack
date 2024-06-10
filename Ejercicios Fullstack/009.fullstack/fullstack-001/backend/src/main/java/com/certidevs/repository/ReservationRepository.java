package com.certidevs.repository;

import com.certidevs.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    void deleteByBookId(Long bookId);
}