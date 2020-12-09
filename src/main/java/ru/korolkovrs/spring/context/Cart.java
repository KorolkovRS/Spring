package ru.korolkovrs.spring.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {
    private Map<Product, Integer> productMap;
    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productMap = new HashMap<>();
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void addProduct(long id) throws IllegalAccessException{
        Product product = productRepository.getProductByID(id);
        if (product != null) {
            if (productMap.containsKey(product)) {
                int count = productMap.get(product);
                productMap.put(product, ++count);
            } else {
                productMap.put(product, 1);
            }
        } else {
            throw new IllegalAccessException("no id in cart");
        }
    }

    public void removeProduct(long id) throws IllegalAccessException {
        Product product = productRepository.getProductByID(id);
        if (product != null) {
            if (productMap.containsKey(product)) {
                int count = productMap.get(product);
                if (count == 1) {
                    productMap.remove(product);
                } else {
                    productMap.put(product, --count);
                }
            } else {
                throw new IllegalAccessException("no id in cart");
            }
        } else {
            throw new IllegalAccessException("wrong product id");
        }
    }

    public float getPrice() {
        float sum = 0f;
        for (Map.Entry<Product, Integer> map: productMap.entrySet()) {
            sum += map.getKey().getPrice() * map.getValue();
        }
        return sum;
    }
}
