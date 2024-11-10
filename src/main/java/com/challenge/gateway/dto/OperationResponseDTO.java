package com.challenge.gateway.dto;

import java.math.BigDecimal;

/**
 * A Data Transfer Object (DTO) representing the response of an operation.
 *
 * This class encapsulates the result and any error message related to the operation.
 */
public class OperationResponseDTO {

    private BigDecimal result;
    private String error;

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
