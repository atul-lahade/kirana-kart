package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when file type is not supported
 */
public class UnsupportedFileTypeException extends BaseException {

    public UnsupportedFileTypeException(String fileType) {
        super("Unsupported file type: " + fileType, HttpStatus.BAD_REQUEST, "FILE_002");
    }
}