package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when payment fails
 */
public class PaymentException extends BaseException {

    public PaymentException(String message) {
        super(message, HttpStatus.PAYMENT_REQUIRED, "PAY_001");
    }

    public PaymentException(String message, Throwable cause) {
        super(message, cause, HttpStatus.PAYMENT_REQUIRED, "PAY_001");
    }
}