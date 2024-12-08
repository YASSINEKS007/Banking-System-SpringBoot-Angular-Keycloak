package me.projects.customerservice.services;

import me.projects.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long customerId);

    List<Customer> getCustomers();

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);
}
