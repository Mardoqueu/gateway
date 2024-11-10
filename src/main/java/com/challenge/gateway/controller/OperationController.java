package com.challenge.gateway.controller;

import com.challenge.gateway.dto.OperationDTO;
import com.challenge.gateway.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * REST controller for handling operation-related requests.
 */
@RestController
@RequestMapping("/operations")
public class OperationController {

    /**
     * Service for handling operations.
     */
    private final OperationService operationService;

    /**
     * Constructs an OperationController with the provided OperationService.
     *
     * @param operationService the service to be used for handling operation-related requests
     */
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    /**
     * Executes an operation based on the provided {@code operationDTO}.
     *
     * @param operationDTO the data transfer object containing the user ID and the operation expression
     * @return a {@code ResponseEntity} containing the*/
    @PostMapping("/execute")
    public ResponseEntity<BigDecimal> executeOperation(@RequestBody OperationDTO operationDTO) {
        return ResponseEntity.ok(operationService.executeOperation(operationDTO));
    }

    /**
     * Generates a random string for the specified user.
     *
     * @param userId The unique identifier of the user for whom to generate the random string.
     * @return A ResponseEntity containing the generated random string.
     */
    @PostMapping("/random-string")
    public ResponseEntity<String> randomString(@RequestParam Long userId) {
        String randomString = operationService.randomString(userId);
        return ResponseEntity.ok(randomString);
    }

}
