package me.projects.orderservice.services;

import me.projects.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
@Service
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    public List<Customer> getCustomers();
}
