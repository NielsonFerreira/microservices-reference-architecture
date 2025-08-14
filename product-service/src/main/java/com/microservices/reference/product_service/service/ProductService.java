package com.microservices.reference.product_service.service;

import com.microservices.reference.product_service.dto.ProductDTO;
import com.microservices.reference.product_service.model.Product;
import com.microservices.reference.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductDTO createProduct(ProductDTO dto) {
        Product product = Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build();
        Product saved = repository.save(product);
        return mapToDTO(saved);
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}