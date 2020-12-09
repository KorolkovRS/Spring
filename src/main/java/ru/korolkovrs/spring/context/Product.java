package ru.korolkovrs.spring.context;

import java.util.Objects;

public class Product {
    private long id;
    private String title;
    private float price;

    public Product(long id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title=" + title +
                ", price=" + price;
    }
}
