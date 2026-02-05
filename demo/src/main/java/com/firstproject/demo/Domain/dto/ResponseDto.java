package com.firstproject.demo.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String status;
    private String message;
    private Object data;

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
