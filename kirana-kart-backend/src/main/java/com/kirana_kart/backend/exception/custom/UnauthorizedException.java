package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when user is not authorized to access a resource
 */
public class UnauthorizedException extends BaseException {

    public UnauthorizedException(String message) {
        super(message, HttpStatus.FORBIDDEN, "AUTH_002");
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause, HttpStatus.FORBIDDEN, "AUTH_002");
    }
}