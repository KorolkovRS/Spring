package ru.korolkovrs.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.korolkovrs.lesson7.models.Product;
import ru.korolkovrs.lesson7.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional()
    public List<Product> getAllProducts(Integer min, Integer max) {
        if (min != null && max != null) {
            return productRepository.findAllByPriceBetweenOrderByPrice(min, max);
        }
        if (min != null && max == null) {
            return productRepository.findAllByPriceGreaterThanOrderByPrice(min);
        }
        if (min == null && max != null) {
            return productRepository.findAllByPriceLessThanOrderByPriceDesc(max);
        }
        return productRepository.findAll();
    }

    @Transactional()
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Transactional()
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional()
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
