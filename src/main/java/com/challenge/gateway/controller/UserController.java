package com.challenge.gateway.controller;

import com.challenge.gateway.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Controller for handling user-related operations such as adding balance and retrieving
 * user balance. Mapped to the "/users" URI.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * The UserService instance used to handle operations related to user management, such as adding balance
     * and retrieving user balance.
     */
    private final UserService userService;

    /**
     * Constructs a UserController with the specified UserService.
     *
     * @param userService the service used to manage user-related operations
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Adds a specified amount to the user's balance based on their user ID.
     *
     * @param userId the ID of the user whose balance is to be updated
     * @param amount the amount to be added to the user's balance
     * @return a ResponseEntity containing a message indicating the result of the operation
     */
    @PostMapping("/add-balance")
    public ResponseEntity<String> addBalance(@RequestParam Long userId, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok( userService.addBalance(userId, amount));
    }

    /**
     * Retrieves the balance for a given user.
     *
     * @param userId the unique identifier of the user whose balance is to be retrieved
     * @return the balance of the user wrapped in a ResponseEntity
     */
    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalance(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.getBalance(userId));
    }
}
