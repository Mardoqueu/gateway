package com.challenge.gateway.dto;


/**
 * The AuthResponseDTO class is a Data Transfer Object (DTO) used for encapsulating
 * the authentication response payload. This class is primarily used to transfer
 * authentication-related data such as the token and the userId from the authentication
 * service to the client.
 */
public class AuthResponseDTO {
    private String token;
    private Long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}