package com.rushi.productservice.controller;

import com.rushi.productservice.entity.Product;
import com.rushi.productservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        if (product != null) {
            return productRepository.save(product);
        } else
            throw new IllegalArgumentException("Product cannot be null");
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else throw new IllegalArgumentException("Product not found");
    }

}
