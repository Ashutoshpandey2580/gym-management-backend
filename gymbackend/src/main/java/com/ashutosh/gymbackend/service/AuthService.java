package com.ashutosh.gymbackend.service;

import com.ashutosh.gymbackend.dto.LoginRequest;
import com.ashutosh.gymbackend.dto.RegisterRequest;
import com.ashutosh.gymbackend.entity.User;
import com.ashutosh.gymbackend.repository.UserRepository;
import com.ashutosh.gymbackend.security.JwtService;
import io.jsonwebtoken.Jwt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // REGISTER
    public User register(RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return repository.save(user);

    }

    // LOGIN
    public String login(LoginRequest request){

        User user = repository
                .findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

       if (passwordEncoder.matches(
               request.getPassword(),
               user.getPassword()
       )){
            return jwtService.generateToken(
                    user.getUsername(),
                    user.getRole()
            );
        }

        throw new RuntimeException("Invalid Password");
    }
     public List<User>getAllUsers(){
        return repository.findAll();
     }


}