package ru.korolkovrs.spring.boot.lesson4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.korolkovrs.spring.boot.lesson4.models.Product;
import ru.korolkovrs.spring.boot.lesson4.services.ProductService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping("/add")
    public String addOrReplaceProduct(@RequestParam String title, @RequestParam float cost) {
        Product product = new Product(title, new BigDecimal(cost).setScale(2, RoundingMode.DOWN));
        try {
            productService.addOrReplaceProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/products";
    }
}
