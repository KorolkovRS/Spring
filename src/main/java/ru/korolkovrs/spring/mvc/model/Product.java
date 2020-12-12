package ru.korolkovrs.spring.mvc.model;

public class Product {
    private long id;
    private String title;
    private float cost;

    public Product() {
    }

    public Product(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
