package com.microservices.reference.user_service.service;

import com.microservices.reference.user_service.domain.User;
import com.microservices.reference.user_service.dto.UserDTOs;
import com.microservices.reference.user_service.exception.NotFoundException;
import com.microservices.reference.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    @Transactional
    public User create(UserDTOs.CreateRequest req) {
        if (repo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        var user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .build();
        return repo.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(UUID id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repo.findAll();
    }

    @Transactional
    public User update(UUID id, UserDTOs.UpdateRequest req) {
        var user = findById(id);
        user.setName(req.getName());
        return repo.save(user);
    }

    @Transactional
    public void delete(UUID id) {
        var user = findById(id);
        repo.delete(user);
    }
}