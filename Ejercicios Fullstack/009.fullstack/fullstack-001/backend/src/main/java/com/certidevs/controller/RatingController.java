package com.certidevs.controller;

import com.certidevs.exception.UnauthorizedException;
import com.certidevs.model.Book;
import com.certidevs.model.Rating;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.RatingRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin("*") // Permitir acceso desde cualquier dominio desde el exterior
@RestController
@AllArgsConstructor
@Slf4j
public class RatingController {


    private RatingRepository repo;

    @GetMapping("ratings/filter-by-book/{id}")
    public List<Rating> findAllByBookId(@PathVariable Long id) {
        return this.repo.findByBook_IdOrderByIdDesc(id);
    }

    @PostMapping("ratings")
    public Rating create(@RequestBody() Rating rating) {

        // TODO: si el usuario ya tiene un rating para este mismo book entonces no puede volver a comentar.
        // boolean existsPreviousRatings = this.repo.existsByUserIdAndBookId();

        // Asignar el usuario autenticado antes de guardar el rating:
        SecurityUtils.getCurrentUser().ifPresent(user -> rating.setUser(user));

//        Optional<User> userOptional = SecurityUtils.getCurrentUser();
//        if (userOptional.isPresent()) {
//            rating.setUser(userOptional.get());
//        }
        return this.repo.save(rating);
    }

    @DeleteMapping("ratings/{id}")
    public void deleteById(@PathVariable Long id) {

        Rating rating = this.repo.findById(id).orElseThrow();
        User user = SecurityUtils.getCurrentUser().orElseThrow();

        if(user.getRole().equals(Role.ADMIN) ||
                (rating.getUser() != null && rating.getUser().getId().equals(user.getId()))
        )
            this.repo.deleteById(id);
        else
            throw new UnauthorizedException("No puede borrar el rating");






    }

}
