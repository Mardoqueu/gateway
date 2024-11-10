package com.challenge.gateway.infrastructure.clients;

import com.challenge.gateway.dto.AuthRequestDTO;
import com.challenge.gateway.dto.UserDTO;
import com.challenge.gateway.dto.AuthResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The AuthenticationClient interface represents an Feign client used for
 * interacting with an external authentication service. This client provides
 * functionalities for user registration and user authentication.
 */
@FeignClient(value="authClient", url = "https://api-authentication-c444a1ad4280.herokuapp.com/api/auth")
public interface AuthenticationClient {

    /**
     * Registers a new user by sending the provided UserDTO to the authentication service.
     *
     * @param userDTO the UserDTO object containing the user's registration details
     * @return the UserDTO object containing the registered user's details as returned by the authentication service
     */
    @PostMapping("/register")
    UserDTO registerUser(@RequestBody UserDTO userDTO);

    /**
     * Authenticates a user based on the provided authentication request data.
     *
     * @param requestDTO an AuthRequestDTO containing the user's authentication credentials, specifically the username and password
     * @return an AuthResponseDTO containing the authentication token and userId if authentication is successful
     */
    @PostMapping("/login")
    AuthResponseDTO loginUser(@RequestBody AuthRequestDTO requestDTO);
}
