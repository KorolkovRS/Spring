package ru.korolkovrs.spring.context;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductAnotherRepository implements ProductRepository {
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductByID(long id) {
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }
}
