package com.udemy.test.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class JsonResponse {
    private int status;
    private String message;
    private Object data;

    public JsonResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
