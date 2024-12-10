package me.projects.orderservice.mappers;


import me.projects.orderservice.dtos.OrderDTO;
import me.projects.orderservice.dtos.ProductItemDTO;
import me.projects.orderservice.entities.Order;
import me.projects.orderservice.entities.ProductItem;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BillMapper {

    public ProductItemDTO fromProductItem(ProductItem productItem) {
        ProductItemDTO productItemDTO = new ProductItemDTO();
        productItemDTO.setId(productItem.getId());
        productItemDTO.setProductId(productItem.getProductId());
        productItemDTO.setPrice(productItem.getPrice());
        productItemDTO.setQuantity(productItem.getQuantity());
        productItemDTO.setDiscount(productItem.getDiscount());
        productItemDTO.setProduct(productItem.getProduct());

        return productItemDTO;
    }

    public OrderDTO fromOrder(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCreated(order.getCreated());
        orderDTO.setOrderStatus(order.getOrderStatus().name());
        orderDTO.setCustomer(order.getCustomer());

        // Convert stream to List using .collect(Collectors.toList())
        orderDTO.setProductItems(
                order.getProductItems().stream()
                        .map(this::fromProductItem)  // Method reference for simplicity
                        .collect(Collectors.toList())  // Collect stream into List
        );

        return orderDTO;
    }
}
