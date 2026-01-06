package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when order cannot be processed
 */
public class OrderProcessingException extends BaseException {

    public OrderProcessingException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "ORD_002");
    }

    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR, "ORD_002");
    }
}