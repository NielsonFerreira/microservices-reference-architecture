package com.microservices.reference.user_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Ping Pong", description = "Ping pong endpoint")
public class PingPongController {

    @GetMapping("/ping")
    @Operation(summary = "Ping endpoint", description = "Returns pong")
    public String ping() {
        return "pong";
    }
}