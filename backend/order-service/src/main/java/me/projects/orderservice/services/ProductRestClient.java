package me.projects.orderservice.services;

import me.projects.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);

    @GetMapping("/products")
    List<Product> getProducts();
}
