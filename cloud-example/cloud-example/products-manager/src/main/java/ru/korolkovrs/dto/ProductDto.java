package ru.korolkovrs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.korolkovrs.models.Product;

@NoArgsConstructor
@Data
public class ProductDto {
    private Long id;
    private String title;
    private int price;

    public ProductDto(Product p) {
        id = p.getId();
        title = p.getTitle();
        price = p.getPrice();
    }
}
