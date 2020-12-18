package ru.korolkovrs.hibernate.crud;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private int price;

    public Product(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }
}
