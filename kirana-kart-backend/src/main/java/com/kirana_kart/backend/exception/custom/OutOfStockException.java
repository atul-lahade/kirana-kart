package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when product is out of stock
 */
public class OutOfStockException extends BaseException {

    public OutOfStockException(String productName) {
        super("Product out of stock: " + productName, HttpStatus.BAD_REQUEST, "INV_001");
    }

    public OutOfStockException(String productName, int requestedQuantity, int availableQuantity) {
        super(String.format("Insufficient stock for %s. Requested: %d, Available: %d",
                        productName, requestedQuantity, availableQuantity),
                HttpStatus.BAD_REQUEST, "INV_001");
    }
}