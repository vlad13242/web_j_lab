package com.Java.infrastructure.repository;

import com.Java.domain.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryProductRepository {

    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); 

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter.getAndIncrement()); 
        }
        products.add(product);
        return product;
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
