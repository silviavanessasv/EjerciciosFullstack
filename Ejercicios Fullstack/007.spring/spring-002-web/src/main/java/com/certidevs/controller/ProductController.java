package com.certidevs.controller;


import com.certidevs.model.Product;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController { // resource / controller

    // find all Array List
    @GetMapping("products") // endpoint
    public List<Product> findAll() {
        // Crear lista de objetos producto
        List<Product> products = new ArrayList<>();

        // Crear 3 productos
        Product tvSamsung = new Product(1L, "TV Samsung 52", 450.0, true, LocalDate.now());
        Product pcMSI = new Product(2L, "PC MSI Modern", 600.0, false, null);
        Product spOnePlus = new Product(3L, "One Plus 12", 900.0, true, LocalDate.now());

        // insertar 3 productos
        products.add(tvSamsung);
        products.add(pcMSI);
        products.add(spOnePlus);

        // devolver la lista con return
        return products;
    }

    @GetMapping("products2")
    public List<Product> findAll2() {

        return List.of(
                new Product(1L, "TV Samsung 52", 450.0, true, LocalDate.now()),
                new Product(2L, "PC MSI Modern", 600.0, false, null)
        );
    }

    @GetMapping("product-demo")
    public Product findProduct(){
        return new Product(1L, "TV Samsung 52", 450.0, true, LocalDate.now());
    }

    // CON VARIABLES EN LA URL
    // Reciba una variable id numérica y buscamos el producto por ese id, en un arraylist, en base de datos
    @GetMapping("products/{id}") // http://localhost:8080/products/5
    public Product findProductById(@PathVariable Long id) {
        // buscar el producto en base de datos filtrando por su id (clave primaria)
        return new Product(id, "Botella Metal", 13.0, true, LocalDate.now());
    }

    @GetMapping("products/by-title/{title}") // http://localhost:8080/products/by-title/televisor
    public Product findProductByTitle(@PathVariable String title) {
        return new Product(1L, title, 13.0, true, LocalDate.now());
    }



     @GetMapping("products/by-price/{min}/{max}")  // http://localhost:8080/products/by-price/80/150
//    @GetMapping("products/by-price/min/{min}/max/{max}") // http://localhost:8080/products/by-price/min/80/max/150 SELECT * FROM products where price > min and price < max
    public List<Product> findAllByPriceMinAndMax(@PathVariable Double min, @PathVariable Double max) {
        System.out.println("min " + min + " max " + max);
        // if (min >= max)
        //    throw new IllegalArgumentException(); // Tratar excepciones con ResponseEntity

        return List.of(
                new Product(1L, "TV Samsung 52", 450.0, true, LocalDate.now()), // hardcoded values. Replace with real data from database
                new Product(2L, "PC MSI Modern", 600.0, false, null)
        );
    }

    // RECIBIR DATOS DESDE EL EXTERIOR EN JSON - OBJETIVO CREA UN NUEVO DATO EN BASE DE DATOS
    @PostMapping("products") // no colisiona con GetMapping
    public Product create(@RequestBody Product product) {

        // PARA POST NO DEBERÍA HABER ID, ES COMÚN LANZAR UN ERROR SI VIENE CON ID PORQUE YA LO CREA LA BASE DE DATOS
        System.out.println(product.id());

        // guardar en base de datos
        // se le genera un nuevo id ....
        // devolver el product con el nuevo id
        return product;
    }

    // RECIBIR DATOS DESDE EL EXTERIOR - OBJETIVO ACTUALIZAR UN DATO EXISTENTE
    @PutMapping("products/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {
        // PARA `PUT` SÍ DEBERÍA HABER ID, PORQUE SE QUIERE ACTUALIZAR ALGO QUE YA FUE CREADO EN DB POR POST
        System.out.println(product.id());
        // Actualizar en base de datos

        return product;

    }

    @DeleteMapping("products/{id}")
    public void deleteById(@PathVariable Long id) {
        // delete from products where id = :id
        // se borraría el producto que coincida con este id en base de datos
        // RIESGO: si hay claves foráneas habría que desasociar o borrar o tener una operación en cascada configurada
        System.out.println("Borrando producto " + id);
    }

 // pendiente ver: ResponseEntity, utilizar ArrayList como db en el propio controlador
}
