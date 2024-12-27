package com.Java.presentation.validation;

import com.Java.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestValidator {

    public void validate(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (product.getPrice() == null || product.getPrice().doubleValue() <= 0) {
            throw new IllegalArgumentException("Product price must be greater than 0.");
        }
    }
}
