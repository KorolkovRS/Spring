package ru.korolkovrs.lesson7.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.korolkovrs.lesson7.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanOrderByPrice(int min);
    List<Product> findAllByPriceBetweenOrderByPrice(int min, int max);
    List<Product> findAllByPriceLessThanOrderByPriceDesc(int max);
}
