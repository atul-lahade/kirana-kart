package com.kirana_kart.backend.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = 3410901347252367997L;
    private Integer status;
    private String message;
    private T data;
}