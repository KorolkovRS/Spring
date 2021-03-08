package ru.korolkovrs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.korolkovrs.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
