package com.microservices.reference.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

public class UserDTOs {

    @Value
    public static class CreateRequest {
        @NotBlank @Size(max = 120) String name;
        @NotBlank @Email @Size(max = 180) String email;
    }

    @Value
    public static class UpdateRequest {
        @NotBlank @Size(max = 120) String name;
    }

    @Value
    @Builder
    public static class Response {
        UUID id;
        String name;
        String email;
    }
}
