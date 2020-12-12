package ru.korolkovrs.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.korolkovrs.spring.mvc.model.Product;
import ru.korolkovrs.spring.mvc.services.ProductService;

import java.util.List;

@Component
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam int cost) {
        Product product = new Product(title, cost);
        productService.addProduct(product);
    return "redirect:/products/";
    }

}
