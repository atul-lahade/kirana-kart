package com.kirana_kart.backend.exception.custom;

import com.kirana_kart.backend.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown when category is not found
 */
public class CategoryNotFoundException extends BaseException {

    public CategoryNotFoundException(String categoryId) {
        super("Category not found with id: " + categoryId, HttpStatus.NOT_FOUND, "CAT_001");
    }
}