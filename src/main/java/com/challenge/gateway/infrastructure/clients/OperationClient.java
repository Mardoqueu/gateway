package com.challenge.gateway.infrastructure.clients;

import com.challenge.gateway.config.FeignConfig;
import com.challenge.gateway.dto.OperationDTO;
import com.challenge.gateway.dto.OperationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.challenge.gateway.dto.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.math.BigDecimal;

/**
 * Feign client interface for interacting with the operations API.
 */
@FeignClient(value="operationsClient", url = "https://api-operations-0934b01de2bd.herokuapp.com/api/operations",  configuration = FeignConfig.class)
public interface OperationClient {

    /**
     * Generates a random string for the specified user.
     *
     * @param userId the identifier of the user for whom the random string is to be generated
     * @return a randomly generated string for the specified user
     */
    @PostMapping("/random-string")
     String randomString(@RequestParam Long userId);

    /**
     * Executes an operation based on the given OperationDTO.
     *
     * @param operationDTO the data transfer object containing user information and the operation expression.
     * @return the result of the operation as a BigDecimal.
     */
    @PostMapping("/execute")
    BigDecimal executeOperation(@RequestBody OperationDTO operationDTO);

    @GetMapping
    public List<Operation> getAllOperations();
    @DeleteMapping("/{id}")
    public String deleteOperation(@PathVariable Long id);
}
