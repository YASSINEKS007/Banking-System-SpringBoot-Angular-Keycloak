package me.projects.customerservice.services;

import lombok.AllArgsConstructor;
import me.projects.customerservice.entities.Customer;
import me.projects.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(customerId).orElse(null);
        if (customerToUpdate != null) {
            customerToUpdate.setFullName(customer.getFullName());
            customerToUpdate.setEmail(customer.getEmail());
            return customerRepository.save(customerToUpdate);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
