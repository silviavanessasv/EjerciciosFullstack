package com.certidevs.controllers;

import com.certidevs.models.ShopCartHasProductsDTO;
import com.certidevs.models.ShopCartPrice;
import com.certidevs.models.User;
import com.certidevs.services.ProductService;
import com.certidevs.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor // lombok
@RestController // spring
public class ShopCartController {

    private ProductService productService;
    private UserService userService;

    @GetMapping("calculate-total-price")
    public Double getCurrentTotalPrice() {
        return productService.calculateTotalPrice();
    }

    @GetMapping("calculate-total-price2")
    public ResponseEntity<Double> getCurrentTotalPrice2() {
        Double price =  productService.calculateTotalPrice();
        return ResponseEntity.ok(price);
    }
    @GetMapping("calculate-total-price3")
    public ShopCartPrice getCurrentTotalPrice3() {
        Double price =  productService.calculateTotalPrice();
        return new ShopCartPrice(price);
    }
    // Crear método que devuelva un objeto json que diga si hay productos
    // en el listado del servicio: true o false dentro del objeto json
    /*
    {
        "existProducts": true
    }
    Posibles nombres para el DTO: Data Transfer Object
    ProductExistenceDTO,
    ShopCartNotEmptyDTO
    ShopCartHasProductsDTO
     */
    @GetMapping("shopcart-has-products")
    public ShopCartHasProductsDTO checkIfShopCartHasProducts() {
        Boolean exist = productService.checkIfShopCartHasProducts();
        return new ShopCartHasProductsDTO(exist);
    }

    @GetMapping("shopcart-user/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

}
