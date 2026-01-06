package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when database operation fails
 */
public class DatabaseException extends BaseException {

    public DatabaseException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "DB_001");
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR, "DB_001");
    }
}