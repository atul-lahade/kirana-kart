package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when order cannot be cancelled
 */
public class OrderCancellationException extends BaseException {

    public OrderCancellationException(String orderId, String reason) {
        super(String.format("Cannot cancel order %s: %s", orderId, reason),
                HttpStatus.BAD_REQUEST, "ORD_003");
    }
}