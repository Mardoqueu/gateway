package com.challenge.gateway.infrastructure.clients;

import com.challenge.gateway.dto.AuthRequestDTO;
import com.challenge.gateway.dto.UserDTO;
import com.challenge.gateway.dto.AuthResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="authClient", url = "https://api-authentication-c444a1ad4280.herokuapp.com/api/auth")
public interface AuthenticationClient {

    @PostMapping("/register")
    UserDTO registerUser(@RequestBody UserDTO userDTO);

    @PostMapping("/login")
    AuthResponseDTO loginUser(@RequestBody AuthRequestDTO requestDTO);
}
