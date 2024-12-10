package me.projects.inventoryservice;

import me.projects.inventoryservice.entities.Product;
import me.projects.inventoryservice.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                productService.createProduct(Product.builder()
                        .name("Product " + i + 1)
                        .price(Math.random() * 100)
                        .quantity(i)
                        .build());
            }
        };
    }

}
