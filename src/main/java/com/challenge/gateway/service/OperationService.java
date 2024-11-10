package com.challenge.gateway.service;

import com.challenge.gateway.dto.OperationDTO;
import com.challenge.gateway.dto.OperationResponseDTO;
import com.challenge.gateway.infrastructure.clients.OperationClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

/**
 * Service for performing various operations via HTTP requests.
 * This service interacts with remote operation services through OperationClient.
 */
@Service
public class OperationService {

    /**
     * Client interface for performing various operations via HTTP requests.
     * Instances of this client are used to interact with remote operation services.
     */
    private final OperationClient operationClient;

    /**
     * Constructs a new instance of the OperationService.
     *
     * @param operationClient the client used for interacting with the operations API
     */
    public OperationService(OperationClient operationClient) {
        this.operationClient = operationClient;
    }

    /**
     * Generates a random string for the specified user.
     *
     * @param userId the identifier of the user for whom the random string is to be generated
     * @return a randomly generated string for the specified user
     */
    public String randomString(Long userId) {
        return operationClient.randomString(userId);
    }

    /**
     * Executes an operation based on the provided OperationDTO.
     *
     * @param operationDTO the data transfer object containing user information and the operation expression
     * @return the result of the operation as a BigDecimal
     */
    public BigDecimal executeOperation(OperationDTO operationDTO) {
        return operationClient.executeOperation(operationDTO);
    }
}
