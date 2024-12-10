package me.projects.orderservice;

import me.projects.orderservice.entities.Order;
import me.projects.orderservice.entities.ProductItem;
import me.projects.orderservice.enums.OrderStatus;
import me.projects.orderservice.models.Customer;
import me.projects.orderservice.models.Product;
import me.projects.orderservice.repositories.OrderRepository;
import me.projects.orderservice.repositories.ProductItemRepository;
import me.projects.orderservice.services.CustomerRestClient;
import me.projects.orderservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(CustomerRestClient customerRestClient,
//											   ProductRestClient productRestClient,
//											   ProductItemRepository productItemRepository,
//											   OrderRepository billRepository) {
//		return args -> {
//			List<Customer> customers = customerRestClient.getCustomers();
//			List<Product> products = productRestClient.getProducts();
//
//			for (Customer customer : customers) {
//				Order bill = new Order();
//				bill.setCustomer(customer);
//				bill.setCreated(new Date());
//				bill.setCustomerId(customer.getId());
//				bill.setOrderStatus(OrderStatus.CREATED);
//
//				bill = billRepository.save(bill);
//
//				List<ProductItem> productItems = new ArrayList<>();
//				for (Product product : products) {
//					ProductItem productItem = new ProductItem();
//					productItem.setProductId(product.getId());
//					productItem.setOrder(bill);
//					productItem.setProduct(product);
//					productItem.setQuantity(1);
//					productItem.setDiscount(Math.random() * 100);
//					productItem.setPrice(Math.random() * 1000);
//					productItems.add(productItem);
//				}
//				productItemRepository.saveAll(productItems); // Now save all product items
//			}
//		};
//	}
}
