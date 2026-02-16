package com.example.todoapp.Controller;

import com.example.todoapp.DTO.todoRequestDTO;
import com.example.todoapp.DTO.todoResponseDTO;
import com.example.todoapp.Service.todoService;
import com.example.todoapp.util.JwtUtil;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class todoController {

    private final todoService service;
    private final JwtUtil jwtUtil;

    public todoController(todoService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    private void checkToken(String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Invalid or missing token");
        }

        String token = authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    /** ✅ Add Todo */
    @PostMapping("/add")
    public todoResponseDTO addTodo(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody todoRequestDTO todo) {

        checkToken(authHeader);
        return service.addTodo(todo);
    }

    /** ✅ Get all Todos */
    @GetMapping("/all")
    public List<todoResponseDTO> getAllTodos(
            @RequestHeader("Authorization") String authHeader) {

        checkToken(authHeader);
        return service.x`x();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id) {

        checkToken(authHeader);
        service.deleteTodo(id);
        return "Todo Deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public todoResponseDTO updateTodo(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id,
            @Valid @RequestBody todoRequestDTO todo) {

        checkToken(authHeader);
        return service.updateTodo(id, todo);
    }
}
