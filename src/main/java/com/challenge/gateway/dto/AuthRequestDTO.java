package com.challenge.gateway.dto;

/**
 * The AuthRequestDTO class is a Data Transfer Object (DTO) used for encapsulating
 * the authentication request payload. This encapsulates the username and password
 * needed for the authentication process.
 */
public class AuthRequestDTO {
    /**
     * The userName field represents the username of the user for authentication purposes.
     */
    private String userName;
    /**
     * The password associated with the user for authentication.
     */
    private String password;

    /**
     * Default constructor for the AuthRequestDTO class.
     * This constructor initializes a new instance of the AuthRequestDTO class
     * with default values for username and password.
     */
    public AuthRequestDTO() {}

    /**
     * Constructs an AuthRequestDTO with the specified username and password.
     *
     * @param username the username to be set
     * @param password the password to be set
     */
    public AuthRequestDTO(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    /**
     * Retrieves the username associated with this AuthRequestDTO.
     *
     * @return the username as a String.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username for the authentication request.
     *
     * @param username the username to set
     */
    public void setUserName(String username) {
        this.userName = username;
    }

    /**
     * Retrieves the password.
     *
     * @return the password of the authentication request.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this authentication request.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
