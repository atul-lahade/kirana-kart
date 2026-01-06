package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BaseException {

    public EmailAlreadyExistsException(String email) {
        super("Email already registered: " + email, HttpStatus.CONFLICT, "AUTH_004");
    }
}
