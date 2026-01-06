package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when email verification fails
 */
public class EmailVerificationException extends BaseException {

    public EmailVerificationException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "AUTH_005");
    }
}