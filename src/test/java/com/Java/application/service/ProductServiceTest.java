package com.Java.application.service;

import com.Java.domain.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testCreateProduct() {
        Product product = new Product("Galaxy", BigDecimal.valueOf(99.99), "A star galaxy product");
        Product createdProduct = productService.createProduct(product);
        assertNotNull(createdProduct);
        assertEquals("Galaxy", createdProduct.getName());
    }

    @Test
    void testGetAllProducts() {
        Product product1 = new Product("Galaxy", BigDecimal.valueOf(99.99), "A star galaxy product");
        Product product2 = new Product("Star", BigDecimal.valueOf(49.99), "A star product");

        productService.createProduct(product1);
        productService.createProduct(product2);

        assertEquals(2, productService.getAllProducts().size());
    }

    @Test
    void testGetProductById() {
        Product product = new Product("Star", BigDecimal.valueOf(49.99), "A star product");
        Product createdProduct = productService.createProduct(product);

        Optional<Product> fetchedProduct = productService.getProductById(createdProduct.getId());
        assertTrue(fetchedProduct.isPresent());
        assertEquals("Star", fetchedProduct.get().getName());
    }
}
