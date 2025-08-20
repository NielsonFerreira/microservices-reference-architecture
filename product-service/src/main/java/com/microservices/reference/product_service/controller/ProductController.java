package com.microservices.reference.product_service.controller;

import com.microservices.reference.product_service.dto.ProductDTO;
import com.microservices.reference.product_service.kafka.ProductProducer;
import com.microservices.reference.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductProducer producer;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
        ProductDTO created = service.createProduct(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @PostMapping("/publish")
    public String publishProduct(@RequestParam String name) {
        producer.sendProductEvent("Novo produto: ".concat(name));
        log.info("::: PRODUTOR PUBLICADO: ".concat(name));
        return "Produto publicado: ".concat(name);
    }
}