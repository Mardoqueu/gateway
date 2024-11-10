package com.challenge.gateway.infrastructure.clients;

import com.challenge.gateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * UserClient is a Feign client interface for interacting with the user-related endpoints of an external API.
 */
@FeignClient(name="userClient", url="https://api-operations-0934b01de2bd.herokuapp.com/api/users",  configuration = FeignConfig.class)
public interface UserClient {

    /**
     * Adds a specified amount to the balance of the specified user.
     *
     * @param userId The ID of the user whose balance is to be updated.
     * @param amount The amount to be added to the user's balance.
     * @return A message indicating the status of the balance update.
     */
    @PostMapping("/add-balance")
    public String addBalance(@RequestParam Long userId, @RequestParam BigDecimal amount);

    /**
     * Retrieves the balance for the specified user.
     *
     * @param userId the ID of the user whose balance is to be retrieved
     * @return the balance of the specified user as a BigDecimal
     */
    @GetMapping("/balance")
    public BigDecimal getBalance(@RequestParam Long userId);

}
