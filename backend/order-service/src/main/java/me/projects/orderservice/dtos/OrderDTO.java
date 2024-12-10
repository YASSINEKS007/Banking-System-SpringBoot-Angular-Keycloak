package me.projects.orderservice.dtos;

import lombok.Getter;
import lombok.Setter;
import me.projects.orderservice.models.Customer;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private Date created;
    private String orderStatus;
    private Customer customer;
    private List<ProductItemDTO> productItems;
}
