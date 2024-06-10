package com.certidevs.services;

import com.certidevs.models.Product;
import com.certidevs.models.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @AllArgsConstructor No usamos lombok porque ya creamos
// un constructor personalizado con datos demo
@Service
public class ProductService {

    private List<Product> products;
    private UserService userService;

    public ProductService (UserService userService) {
        this.userService = userService;
        // Comprobar que userservice está correctamente inyectado:
        this.userService.findById(1L);
        System.out.println("UserService inyectado correctamente en ProductService");

        products = new ArrayList<>();
        products.add(
                Product.builder()
                        .id(1L)
                        .price(30.0)
                        .title("Producto 1")
                        .type(ProductType.LAPTOP)
                        .available(true)
                        .build()
        );

        Product product2 = new Product(2L, "Producto2", 30.5, ProductType.MONITOR, true);
        products.add(product2);

        Product product3 = new Product();
        product3.setId(3L);
        product3.setTitle("Product3");
        product3.setPrice(40.3);
        product3.setType(ProductType.MONITOR);
        product3.setAvailable(false);
        products.add(product3);
    }

    public List<Product> findAll(){
        return new ArrayList<>(products); // crea una copia del arraylist productos
    }

    public Double calculateTotalPrice() {
        return 100.0;
    }

    public Boolean checkIfShopCartHasProducts() {
        // return this.products.size() > 0;
        return !this.products.isEmpty();
    }
}
