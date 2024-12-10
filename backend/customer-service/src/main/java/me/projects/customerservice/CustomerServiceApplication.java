package me.projects.customerservice;

import me.projects.customerservice.entities.Customer;
import me.projects.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                Customer customer = new Customer();
                customer.setFullName("Customer " + (i + 1));
                customer.setEmail("customer" + (i + 1) + "@gmail.com");
                customerRepository.save(customer);
            }
        };
    }

}
