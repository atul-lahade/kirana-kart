package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when user is not found
 */
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String userId) {
        super("User not found with id: " + userId, HttpStatus.NOT_FOUND, "USER_001");
    }

    public UserNotFoundException(String fieldName, String fieldValue) {
        super(String.format("User not found with %s: %s", fieldName, fieldValue),
                HttpStatus.NOT_FOUND, "USER_001");
    }
}