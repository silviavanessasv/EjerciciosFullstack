package com.certidevs.controller;

import com.certidevs.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/cliente") // Chrome: http://localhost:8080/cliente
    public String devolverCliente() {
        return "Cliente 1 El míster";
    }

    @GetMapping(value = "/cust")
    public Customer devolverObjeto() {
        // IMPORTANTE: crear getter/setter si los atributos están encapsulados
        Customer customer = new Customer("11122233J", "Mike", 30, true);
        System.out.println(customer);
        // Esto devuelve un JSON
        // {"nif":"11122233J","firstName":"Mike","age":30,"active":true}
        // NO CONFUNDIR CON toString()
        return customer;
    }
}
