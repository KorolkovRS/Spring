package ru.korolkovrs.spring.mvc.services;

import org.springframework.stereotype.Component;
import ru.korolkovrs.spring.mvc.model.Product;
import ru.korolkovrs.spring.mvc.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }
}
