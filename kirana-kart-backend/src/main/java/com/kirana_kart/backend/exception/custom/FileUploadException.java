package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when file upload fails
 */
public class FileUploadException extends BaseException {

    public FileUploadException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "FILE_001");
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause, HttpStatus.INTERNAL_SERVER_ERROR, "FILE_001");
    }
}