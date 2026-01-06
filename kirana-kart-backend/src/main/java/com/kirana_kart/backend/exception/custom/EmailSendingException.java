package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when email sending fails
 */
public class EmailSendingException extends BaseException {

    public EmailSendingException(String message) {
        super("Failed to send email: " + message, HttpStatus.INTERNAL_SERVER_ERROR, "EMAIL_001");
    }

    public EmailSendingException(String message, Throwable cause) {
        super("Failed to send email: " + message, cause,
                HttpStatus.INTERNAL_SERVER_ERROR, "EMAIL_001");
    }
}