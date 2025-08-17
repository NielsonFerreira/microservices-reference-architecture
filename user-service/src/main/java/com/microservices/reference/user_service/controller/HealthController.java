package com.microservices.reference.user_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
@Tag(name = "Health", description = "Endpoints de verificação de saúde")
public class HealthController {

    @GetMapping("/ping")
    @Operation(summary = "Verifica se o serviço está ativo",
            description = "Retorna 'pong' para indicar que o serviço está ativo")
    public String ping() {
        return "pong";
    }
}
