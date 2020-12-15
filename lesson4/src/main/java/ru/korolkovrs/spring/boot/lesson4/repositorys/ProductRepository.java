package ru.korolkovrs.spring.boot.lesson4.repositorys;

import ru.korolkovrs.spring.boot.lesson4.models.Product;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long id);
    public void addOrReplaceProduct(Product product) throws Exception;
    public boolean deleteById(Long id);
}
