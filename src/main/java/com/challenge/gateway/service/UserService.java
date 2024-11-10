package com.challenge.gateway.service;


import com.challenge.gateway.dto.OperationDTO;
import com.challenge.gateway.infrastructure.clients.UserClient;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/**
 * Service class for handling user-related operations such as adding balance
 * and retrieving user balance.
 */
@Service
public class UserService {

    /**
     * UserClient is a Feign client interface for interacting with the user-related endpoints of an external API.
     * It provides methods to add balance to a user's account and retrieve the balance of a user's account.
     */
    private final UserClient userClient;

    /**
     * Constructs a new instance of UserService with the specified UserClient.
     *
     * @param userClient The UserClient used for interacting with user-related endpoints.
     */
    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    /**
     * Adds a specified amount to the user's balance based on their user ID.
     *
     * @param userId the ID of the user whose balance is to be updated
     * @param amount the amount to be added to the user's balance
     * @return a message indicating the result of the balance update
     */
    public String addBalance(Long userId,BigDecimal amount) {
        return userClient.addBalance(userId, amount);
    }

    /**
     * Retrieves the balance for the specified user.
     *
     * @param userId the ID of the user whose balance is to be retrieved
     * @return the balance of the specified user as a BigDecimal
     */
    public BigDecimal getBalance(Long userId) {
        return userClient.getBalance(userId);
    }
}
