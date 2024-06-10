package com.certidevs.controllers;


import com.certidevs.models.Product;

import com.certidevs.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {

    private ProductService productService;

    @GetMapping("products")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }
}
