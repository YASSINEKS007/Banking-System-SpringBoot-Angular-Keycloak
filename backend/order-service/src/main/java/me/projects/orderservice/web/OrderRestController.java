package me.projects.orderservice.web;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import me.projects.orderservice.dtos.OrderDTO;
import me.projects.orderservice.entities.Order;
import me.projects.orderservice.mappers.BillMapper;
import me.projects.orderservice.models.Customer;
import me.projects.orderservice.models.Product;
import me.projects.orderservice.repositories.OrderRepository;
import me.projects.orderservice.services.CustomerRestClient;
import me.projects.orderservice.services.ProductRestClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class OrderRestController {
    private OrderRepository orderRepository;
    private BillMapper billMapper;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    @GetMapping("/orders/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

        // Optionally fetch the customer and products from external services
        Customer customer = customerRestClient.getCustomerById(order.getCustomerId());
        order.setCustomer(customer);

        order.getProductItems().forEach(productItem -> {
            Product product = productRestClient.getProduct(productItem.getProductId());
            productItem.setProduct(product);
        });

        // Map entity to DTO and return
        return billMapper.fromOrder(order);
    }

    @GetMapping("/orders-by-user/{id}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long id) {
        List<Order> orders = orderRepository.findByCustomerId(id);

        // If you want to ensure the customer information is available in each order
        orders.forEach(order -> {
            Customer customer = customerRestClient.getCustomerById(order.getCustomerId());
            order.setCustomer(customer); // Set the customer for each order

            // For each product item in the order, set the product details
            order.getProductItems().forEach(productItem -> {
                Product product = productRestClient.getProduct(productItem.getProductId());
                productItem.setProduct(product); // Set the product for each product item
            });
        });

        // Map the list of orders to OrderDTOs and return
        return orders.stream()
                .map(billMapper::fromOrder) // Assuming fromOrder method returns OrderDTO
                .collect(Collectors.toList());
    }

}
