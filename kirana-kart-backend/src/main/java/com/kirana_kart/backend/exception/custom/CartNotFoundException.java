package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when cart is not found
 */
public class CartNotFoundException extends BaseException {

    public CartNotFoundException(String userId) {
        super("Shopping cart not found for user: " + userId, HttpStatus.NOT_FOUND, "CART_001");
    }
}