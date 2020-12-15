package ru.korolkovrs.spring.boot.lesson4.services;

import org.springframework.stereotype.Component;
import ru.korolkovrs.spring.boot.lesson4.models.Product;
import ru.korolkovrs.spring.boot.lesson4.repositorys.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public void addOrReplaceProduct(Product product) throws Exception {
        productRepository.addOrReplaceProduct(product);
    }

    public boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }
}
