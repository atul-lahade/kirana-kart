package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when discount code is invalid
 */
public class InvalidDiscountCodeException extends BaseException {

    public InvalidDiscountCodeException(String code) {
        super("Invalid or expired discount code: " + code, HttpStatus.BAD_REQUEST, "DISC_001");
    }

    public InvalidDiscountCodeException(String code, String reason) {
        super(String.format("Discount code '%s' is invalid: %s", code, reason),
                HttpStatus.BAD_REQUEST, "DISC_001");
    }
}