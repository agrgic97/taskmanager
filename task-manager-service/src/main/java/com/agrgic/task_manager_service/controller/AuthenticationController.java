package com.agrgic.task_manager_service.controller;

import com.agrgic.task_manager_service.model.LoginResponse;
import com.agrgic.task_manager_service.service.JwtService;
import com.agrgic.task_manager_service.model.LoginUserDTO;
import com.agrgic.task_manager_service.model.RegisterUserDTO;
import com.agrgic.task_manager_service.model.User;
import com.agrgic.task_manager_service.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO user) {
        User registeredUser = authenticationService.signup(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDTO user) {
        User authenticatedUser = authenticationService.authenticate(user);
        String token = jwtService.generateToken(authenticatedUser.getUsername());
        LoginResponse loginResponse = LoginResponse.builder()
                .token(token)
                .expiresIn(jwtService.getExpirationTime()).build();
        return ResponseEntity.ok(loginResponse);
    }
}
