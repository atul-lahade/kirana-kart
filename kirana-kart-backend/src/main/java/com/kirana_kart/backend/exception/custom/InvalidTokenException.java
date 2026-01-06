package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when JWT token is invalid or expired
 */
public class InvalidTokenException extends BaseException {

    public InvalidTokenException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, "AUTH_003");
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause, HttpStatus.UNAUTHORIZED, "AUTH_003");
    }
}