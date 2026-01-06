package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when order is not found
 */
public class OrderNotFoundException extends BaseException {

    public OrderNotFoundException(String orderId) {
        super("Order not found with id: " + orderId, HttpStatus.NOT_FOUND, "ORD_001");
    }
}