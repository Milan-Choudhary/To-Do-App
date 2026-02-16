package com.example.todoapp.Controller;

import com.example.todoapp.DTO.LoginRequestDTO;
import com.example.todoapp.DTO.RegisterRequestDTO;
import com.example.todoapp.DTO.TokenResponseDTO;
import com.example.todoapp.Service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {

    private final AuthService service;

    public authController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public TokenResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public TokenResponseDTO register(@Valid @RequestBody RegisterRequestDTO dto) {
        return service.register(dto);
    }
}
