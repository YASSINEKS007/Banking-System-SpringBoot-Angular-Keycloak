package me.projects.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;
import me.projects.orderservice.models.Product;

@Getter
@Setter
public class ProductItemDTO {
    private Long id;
    private Long productId;
    private Double price;
    private Integer quantity;
    private Double discount;
    private Product product;  // Include only Product details needed
}
