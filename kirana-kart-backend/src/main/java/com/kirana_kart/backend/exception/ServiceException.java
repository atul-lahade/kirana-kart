package com.kirana_kart.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends Exception {

    @Serial
    private static final long serialVersionUID = 3663950444600663161L;

    private String serviceName;
    private String errorCode;
    private String errorDescription;
    private Throwable exception;

}