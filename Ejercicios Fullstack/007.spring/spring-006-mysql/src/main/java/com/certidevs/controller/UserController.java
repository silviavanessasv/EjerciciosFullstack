package com.certidevs.controller;

import com.certidevs.model.User;
import com.certidevs.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserRepository repo;

    @GetMapping("users")
    public List<User> findAll() {
        return repo.findAll();
    }
    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user) {
        // Opcional, se puede optar por comprobar el address si existe
        // si no existe se puede crear con addressRepo.save(user.getAddress()) primero

        try {
            return ResponseEntity.ok(repo.save(user));
        } catch (Exception e) {// capturar errores derivados de guardar en db
            return ResponseEntity.status(409).build(); // No se puede guardar por conflicto con otros usuarios/address
        }
    }
    @PutMapping("users/{id}")
    public User update(@RequestBody User user, @PathVariable Long id){
        return repo.save(user);
    }
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }


}
