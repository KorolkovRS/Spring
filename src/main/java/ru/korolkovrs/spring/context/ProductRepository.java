package ru.korolkovrs.spring.context;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductByID(long id);
    boolean addProduct(Product product);
}
