package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when cart is empty
 */
public class EmptyCartException extends BaseException {

    public EmptyCartException() {
        super("Cannot proceed with empty cart", HttpStatus.BAD_REQUEST, "CART_002");
    }
}