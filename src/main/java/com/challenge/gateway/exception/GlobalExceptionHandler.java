package com.challenge.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A global exception handler for handling various types of exceptions in a Spring Boot application.
 * This class provides centralized exception handling across all {@code @RequestMapping} methods.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ResponseStatusException exceptions by constructing a detailed error response.
     *
     * @param ex the caught ResponseStatusException
     * @return a ResponseEntity containing error details, including timestamp, status code,
     *         reason phrase, and error message
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", ex.getStatusCode().value());
        errorDetails.put("error", getReasonPhrase(ex.getStatusCode()));
        errorDetails.put("message", ex.getReason());
        return new ResponseEntity<>(errorDetails, ex.getStatusCode());
    }

    /**
     * Handles general exceptions that are not explicitly caught by other exception handlers.
     *
     * @param ex the exception that was thrown
     * @return a ResponseEntity containing error details with HTTP status 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", new Date());
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.put("error", "Internal Server Error");
        errorDetails.put("message", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Retrieves a human-readable text representation of an HTTP status code.
     *
     * @param statusCode the HTTP status code for which the reason phrase is required
     * @return the reason phrase corresponding to the provided HTTP status code
     */
    private String getReasonPhrase(HttpStatusCode statusCode) {
        switch (statusCode.value()) {
            case 400: return "Bad Request";
            case 401: return "Unauthorized";
            case 403: return "Forbidden";
            case 404: return "Not Found";
            case 409: return "Conflict";
            case 500: return "Internal Server Error";
            default: return "Unknown Error";
        }
    }
}
