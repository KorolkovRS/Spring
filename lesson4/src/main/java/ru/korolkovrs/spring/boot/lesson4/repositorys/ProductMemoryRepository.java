package ru.korolkovrs.spring.boot.lesson4.repositorys;

import org.springframework.stereotype.Component;
import ru.korolkovrs.spring.boot.lesson4.models.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductMemoryRepository implements ProductRepository {
    private List<Product> productList;
    private Long nextId;

    @PostConstruct
    private void init() {
        productList = new LinkedList<>();
        nextId = 1L;
        try {
            addOrReplaceProduct(new Product("Apple", new BigDecimal("80").setScale(2, RoundingMode.DOWN)));
            addOrReplaceProduct(new Product("Grape", new BigDecimal("200").setScale(2, RoundingMode.DOWN)));
            addOrReplaceProduct(new Product("Potato", new BigDecimal("30").setScale(2, RoundingMode.DOWN)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
//        for (Product product: productList) {
//            if (product.getId().equals(id)) {
//                return Optional.of(product);
//            }
//        }
//        return Optional.of(null);
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public void addOrReplaceProduct(Product product) throws Exception{
        if (product.getId() == null) {
            product.setId(nextId);
            productList.add(product);
            nextId++;
            return;
        }
        if (deleteById(product.getId())) {
            productList.add(product);
            nextId++;
            return;
        }
        throw new Exception("There is no product with this id");
    }

    @Override
    public boolean deleteById(Long id) {
        if(productList.removeIf(p -> p.getId().equals(id))) {
            return true;
        }
        return false;
    }
}
