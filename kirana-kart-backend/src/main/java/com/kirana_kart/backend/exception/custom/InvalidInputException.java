package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when invalid input is provided
 */
public class InvalidInputException extends BaseException {

    public InvalidInputException(String fieldName, String message) {
        super(String.format("Invalid input for %s: %s", fieldName, message),
                HttpStatus.BAD_REQUEST, "VAL_002");
    }
}