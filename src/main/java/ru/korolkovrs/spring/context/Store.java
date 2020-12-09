package ru.korolkovrs.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Store {
    private ProductRepository productRepository;
    private AnnotationConfigApplicationContext context;

    public Store(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setContext(AnnotationConfigApplicationContext context) {
        this.context = context;
    }

    public List<Product> getProductRepository() {
        return productRepository.getAllProducts();
    }

    public Cart getCart() {
        return context.getBean("cart", Cart.class);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
