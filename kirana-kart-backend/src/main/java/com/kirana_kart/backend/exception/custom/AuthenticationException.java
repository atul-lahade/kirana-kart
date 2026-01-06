package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.constants.CommonErrorCodes;
import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when user authentication fails
 */
public class AuthenticationException extends BaseException {

    public AuthenticationException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, CommonErrorCodes.AUTH_AUTHENTICATION_FAILED.getCode());
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause, HttpStatus.UNAUTHORIZED, CommonErrorCodes.AUTH_AUTHENTICATION_FAILED.getCode());
    }
}