package com.Java.application.service;

import com.Java.domain.entity.Product;
import com.Java.infrastructure.repository.InMemoryProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final InMemoryProductRepository repository;

    public ProductService() {
        this.repository = new InMemoryProductRepository();
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public boolean deleteProductById(Long id) {
        return repository.deleteById(id);
    }
}
