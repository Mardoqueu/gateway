package com.challenge.gateway.controller;

import com.challenge.gateway.dto.AuthRequestDTO;
import com.challenge.gateway.dto.UserDTO;
import com.challenge.gateway.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The AuthenticationController class handles authentication-related HTTP requests such as user registration
 * and user login. It interacts with the AuthService to perform these actions.
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    /**
     * Service class responsible for handling authentication-related operations such as user registration and user login.
     */
    private final AuthService authService;

    /**
     * Constructs an AuthenticationController with the given AuthService.
     *
     * @param authService the service for handling authentication operations
     */
    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Registers a new user with the provided user details.
     *
     * @param userDTO The data transfer object containing user details for registration.
     * @return A ResponseEntity containing the registered UserDTO.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authService.registerUser(userDTO));
    }

    /**
     * Handles user login requests.
     *
     * @param requestDTO the authentication request data transfer object containing user's login credentials
     * @return a ResponseEntity containing the authentication response data transfer object with the login results
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequestDTO requestDTO) {
        return ResponseEntity.ok(authService.loginUser(requestDTO));
    }
}
