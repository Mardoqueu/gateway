package com.challenge.gateway.service;

import com.challenge.gateway.dto.AuthRequestDTO;
import com.challenge.gateway.dto.AuthResponseDTO;
import com.challenge.gateway.dto.UserDTO;
import com.challenge.gateway.infrastructure.clients.AuthenticationClient;
import org.springframework.stereotype.Service;

/**
 * The AuthService class is responsible for user registration and authentication.
 * It interacts with an external authentication service through the AuthenticationClient.
 */
@Service
public class AuthService {

    /**
     * Represents the client used for interacting with the external authentication service.
     * Provides methods for user registration and authentication.
     */
    private final AuthenticationClient authenticationClient;

    /**
     * Constructs a new AuthService with the provided AuthenticationClient.
     *
     * @param authenticationClient the AuthenticationClient used to interact with the external authentication service
     */
    public AuthService(AuthenticationClient authenticationClient) {
        this.authenticationClient = authenticationClient;
    }

    /**
     * Registers a new user by sending the provided UserDTO to the authentication service.
     *
     * @param userDTO the UserDTO object containing user registration details
     * @return the UserDTO object containing the registered user's details as returned by the authentication service
     */
    public UserDTO registerUser(UserDTO userDTO) {
        return authenticationClient.registerUser(userDTO);
    }

    /**
     * Authenticates a user based on the provided authentication request data.
     *
     * @param requestDTO an AuthRequestDTO containing the user's authentication credentials, specifically the username and password
     * @return an AuthResponseDTO containing the authentication token and userId if authentication is successful
     */
    public AuthResponseDTO loginUser(AuthRequestDTO requestDTO) {
        return authenticationClient.loginUser(requestDTO);
    }
}
