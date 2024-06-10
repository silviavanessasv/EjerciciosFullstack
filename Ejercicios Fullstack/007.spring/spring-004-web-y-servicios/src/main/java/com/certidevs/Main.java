package com.certidevs;

import com.certidevs.models.Product;
import com.certidevs.models.ProductType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Product pcMSI = new Product();
        Product onePlus = new Product(1L, "Oneplus", 500.0, ProductType.SMART_PHONE, true);
        System.out.println(onePlus.getPrice());


        Product garmin = Product.builder()
                .id(1L)
                .price(500.0)
                .available(true)
                .title("Reloj Garmin")
                .type(ProductType.SMART_WATCH)
                .build();
        System.out.println(garmin);
    }

}
