package com.microservices.reference.common.dto;

import java.time.Instant;

public record ApiResponseDTO<T>(
        Instant timestamp,
        int status,
        String message,
        T data
) {
    public ApiResponseDTO(int status, String message, T data) {
        this(Instant.now(), status, message, data);
    }
}