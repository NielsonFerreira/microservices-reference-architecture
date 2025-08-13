package com.microservices.reference.user_service.controller;

import com.microservices.reference.user_service.domain.User;
import com.microservices.reference.user_service.dto.UserDTOs;
import com.microservices.reference.user_service.mapper.UserMapper;
import com.microservices.reference.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Operações de gerenciamento de usuários")
public class UserController {

    private final UserService service;

    @PostMapping
    @Operation(summary = "Cria um usuário")
    public ResponseEntity<UserDTOs.Response> create(@Valid @RequestBody UserDTOs.CreateRequest req) {
        User saved = service.create(req);
        return ResponseEntity
                .created(URI.create("/api/users/" + saved.getId()))
                .body(UserMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuário por ID")
    public ResponseEntity<UserDTOs.Response> byId(@PathVariable UUID id) {
        return ResponseEntity.ok(UserMapper.toDto(service.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários")
    public ResponseEntity<List<UserDTOs.Response>> all() {
        return ResponseEntity.ok(service.findAll().stream().map(UserMapper::toDto).toList());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados do usuário")
    public ResponseEntity<UserDTOs.Response> update(@PathVariable UUID id,
                                                    @Valid @RequestBody UserDTOs.UpdateRequest req) {
        return ResponseEntity.ok(UserMapper.toDto(service.update(id, req)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove usuário por ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
