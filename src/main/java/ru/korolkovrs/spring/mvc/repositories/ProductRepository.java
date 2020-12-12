package ru.korolkovrs.spring.mvc.repositories;

import org.springframework.stereotype.Component;
import ru.korolkovrs.spring.mvc.model.Product;
import javax.annotation.PostConstruct;

import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;
    private long nextId;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    @PostConstruct
    private void init() {
        nextId = 1;
        addProduct(new Product("Apple", 80f));
        addProduct(new Product("Potato", 20f));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product addProduct(Product product) {
        product.setId(nextId);
        productList.add(product);
        nextId++;
        return product;
    }
}
