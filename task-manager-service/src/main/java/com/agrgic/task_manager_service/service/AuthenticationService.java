package com.agrgic.task_manager_service.service;

import com.agrgic.task_manager_service.exception.UserAlreadyExistsException;
import com.agrgic.task_manager_service.model.LoginUserDTO;
import com.agrgic.task_manager_service.model.RegisterUserDTO;
import com.agrgic.task_manager_service.model.User;
import com.agrgic.task_manager_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User signup(RegisterUserDTO registerUser) {

        if (userRepository.findByUsername(registerUser.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User with username " + registerUser.getUsername() + " already exists");
        }

        User user = User.builder()
                .username(registerUser.getUsername())
                .password(passwordEncoder.encode(registerUser.getPassword()))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true).build();
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO loginUser) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        return userRepository.findByUsername(loginUser.getUsername()).orElseThrow();
    }
}

