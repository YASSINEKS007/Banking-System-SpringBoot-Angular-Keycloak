package me.projects.inventoryservice.services;

import lombok.AllArgsConstructor;
import me.projects.inventoryservice.entities.Product;
import me.projects.inventoryservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product producToUpdate = productRepository.findById(id).orElse(null);
        if (producToUpdate != null) {
            product.setName(product.getName());
            product.setPrice(product.getPrice());
            product.setQuantity(product.getQuantity());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
