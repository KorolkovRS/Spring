package ru.korolkovrs.spring.context;

import org.springframework.stereotype.Component;

public interface UI {
    void start();
    void showCommands();
    void showAssortment();
    void showCart();
    void addProductInCard(long id);
    void removeProductFromCart(long id);
    void takeNewCart();
}
