package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when external API call fails
 */
public class ExternalServiceException extends BaseException {

    public ExternalServiceException(String serviceName, String message) {
        super(String.format("External service '%s' failed: %s", serviceName, message),
                HttpStatus.SERVICE_UNAVAILABLE, "EXT_001");
    }

    public ExternalServiceException(String serviceName, String message, Throwable cause) {
        super(String.format("External service '%s' failed: %s", serviceName, message),
                cause, HttpStatus.SERVICE_UNAVAILABLE, "EXT_001");
    }
}