package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when product is not found
 */
public class ProductNotFoundException extends BaseException {

    public ProductNotFoundException(String productId) {
        super("Product not found with id: " + productId, HttpStatus.NOT_FOUND, "PROD_001");
    }

    public ProductNotFoundException(String fieldName, String fieldValue) {
        super(String.format("Product not found with %s: %s", fieldName, fieldValue),
                HttpStatus.NOT_FOUND, "PROD_001");
    }
}