package com.kirana_kart.backend.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvalidCredentialsException extends RuntimeException {

    private String message;
    private String field;

    public InvalidCredentialsException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
