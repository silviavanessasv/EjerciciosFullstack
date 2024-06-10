package com.certidevs.controller;

import com.certidevs.dto.Customer;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("customers")
    public List<Customer> findAll() {
        return List.of(
                new Customer("c1@gmail.com", "11111"),
                new Customer("c2@gmail.com", "22222")
        );
    }
    @Operation(summary = "Filtrar por Id", description = "Filtra clientes por su clave primaria id de tipo Long")
    @GetMapping("customer/{id}")
    public Customer findById(@PathVariable Long id) {
        return new Customer("c1@gmail.com", "111111");
    }
    @PostMapping("customers")
    public Customer create(@RequestBody Customer customer) {
        return new Customer("c1@gmail.com", "111111");
    }
    @PutMapping("customers")
    public Customer update(@RequestBody Customer customer) {
        return new Customer("c1@gmail.com", "111111");
    }
    @DeleteMapping("customers/{id}")
    public void delete(@PathVariable Long id){

    }


}
