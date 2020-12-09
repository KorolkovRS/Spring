package ru.korolkovrs.spring.context;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ConsoleClient implements UI {
    private Store store;
    private Cart cart;

    public ConsoleClient(Store store) {
        this.store = store;
    }

    public void start() {
        cart = store.getCart();
        Scanner scanner = new Scanner(System.in);
        String command;
        showCommands();
        while (true) {
            try {
                command = scanner.nextLine();
                if (command.equals("help")) {
                    showCommands();
                } else if (command.equals("end")) {
                    break;
                } else if (command.equals("showAssort")) {
                    showAssortment();
                } else if (command.equals("showCart")) {
                    showCart();
                } else if (command.startsWith("add")) {
                    String[] strings = command.split(" ");
                    addProductInCard(Integer.parseInt(strings[1]));
                } else if (command.startsWith("rem")) {
                    removeProductFromCart(Integer.parseInt(command.split(" ")[1]));
                } else if (command.equals("price")) {
                    System.out.println(cart.getPrice());
                } else if (command.equals("newCart")) {
                    takeNewCart();
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }


    @Override
    public void showCommands() {
        System.out.println("help - show commands\n" +
                "showAssort - show all products in store\n" +
                "showCart - show products in cart\n" +
                "add <id> - add product to cart\n" +
                "rem <id> - remove a product from the cart\n" +
                "price - show total price\n" +
                "newCart - get a new cart");
    }

    @Override
    public void showAssortment() {
        List<Product> productList = store.getProductRepository();
        for (Product prod : productList) {
            System.out.println(prod);
        }
    }

    @Override
    public void showCart() {
        Map<Product, Integer> productMap;
        productMap = cart.getProductMap();
        if (productMap.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        for (Map.Entry<Product, Integer> map : productMap.entrySet()) {
            System.out.println(map.getKey() + "\t" + map.getValue());
        }
    }

    @Override
    public void addProductInCard(long id) {
        try {
            cart.addProduct(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            showCart();
        }
    }

    @Override
    public void removeProductFromCart(long id) {
        try {
            cart.removeProduct(id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            showCart();
        }
    }

    @Override
    public void takeNewCart() {
        cart = store.getCart();
        showCart();
    }
}
