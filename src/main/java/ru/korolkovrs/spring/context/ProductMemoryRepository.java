package ru.korolkovrs.spring.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class ProductMemoryRepository implements ProductRepository {
    private List<Product> productList;

    public ProductMemoryRepository() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1L, "Orange", 150f));
        productList.add(new Product(2L, "Apple", 100f));
        productList.add(new Product(3L, "Tomato", 200f));
        productList.add(new Product(4L, "Potato", 30));
        productList.add(new Product(5L, "Cucumber", 80f));
    }

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public Product getProductByID(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        for (Product prod : productList) {
            if (prod.equals(product)) {
                return false;
            }
        }
        productList.add(product);
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product: productList) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}
