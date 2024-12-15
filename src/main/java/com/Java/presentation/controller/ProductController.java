package com.Java.presentation.controller;

import com.Java.application.service.ProductService;
import com.Java.domain.entity.Product;
import com.Java.infrastructure.toggles.FeatureToggleConfig;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final FeatureToggleConfig featureToggleConfig;

    public ProductController(ProductService productService, FeatureToggleConfig featureToggleConfig) {
        this.productService = productService;
        this.featureToggleConfig = featureToggleConfig;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (!featureToggleConfig.isCrudEnabled()) {
            return ResponseEntity.status(403).body("CRUD operations are disabled.");
        }
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        if (!featureToggleConfig.isCrudEnabled()) {
            return ResponseEntity.status(403).body("CRUD operations are disabled.");
        }
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        if (!featureToggleConfig.isCrudEnabled()) {
            return ResponseEntity.status(403).body("CRUD operations are disabled.");
        }
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        if (!featureToggleConfig.isCrudEnabled()) {
            return ResponseEntity.status(403).body("CRUD operations are disabled.");
        }
        boolean deleted = productService.deleteProductById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
