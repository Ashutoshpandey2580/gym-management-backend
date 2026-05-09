package com.ashutosh.gymbackend.controller;

import com.ashutosh.gymbackend.dto.LoginRequest;
import com.ashutosh.gymbackend.dto.RegisterRequest;
import com.ashutosh.gymbackend.entity.User;
import com.ashutosh.gymbackend.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request){

        return service.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        return service.login(request);
    }
    @GetMapping("/users")
    public List<User>getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/admin")
    public String adminAccess(){

        return "Welcome Admin";
    }
}