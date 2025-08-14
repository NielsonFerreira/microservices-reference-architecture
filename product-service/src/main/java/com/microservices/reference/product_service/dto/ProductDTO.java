package com.microservices.reference.product_service.dto;

public record ProductDTO(Long id, String name, String description, Double price) {
}
