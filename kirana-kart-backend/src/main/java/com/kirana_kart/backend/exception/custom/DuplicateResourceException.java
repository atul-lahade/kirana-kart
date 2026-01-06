package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when duplicate entry is found
 */
public class DuplicateResourceException extends BaseException {

    public DuplicateResourceException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s already exists with %s: %s", resourceName, fieldName, fieldValue),
                HttpStatus.CONFLICT, "DB_002");
    }
}