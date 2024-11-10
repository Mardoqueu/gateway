package com.challenge.gateway.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.util.StreamUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * CustomFeignErrorDecoder is an implementation of the ErrorDecoder interface used to decode HTTP error responses
 * received from Feign client interactions and map them to appropriate exceptions based on the HTTP status codes.
 */
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decodes a Response from the server into a corresponding Exception,
     * based on HTTP status codes.
     *
     * @param methodKey the key of the method that triggered the request.
     * @param response the HTTP response received from the server.
     * @return an Exception corresponding to the HTTP status code of the response.
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        String message = extractMessageFromBody(response);

        switch (response.status()) {
            case 400:
                return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
            case 401:
                return new ResponseStatusException(HttpStatus.UNAUTHORIZED, message);
            case 403:
                return new ResponseStatusException(HttpStatus.FORBIDDEN, message);
            case 404:
                return new ResponseStatusException(HttpStatus.NOT_FOUND, message);
            case 409:
                return new ResponseStatusException(HttpStatus.CONFLICT, message);
            case 500:
                return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message);
            default:
                return new Exception(message);
        }
    }

    /**
     * Extracts the message from the response body if available, otherwise returns a default message based on the response status.
     *
     * @param response the response from which to extract the message
     * @return the extracted message if present, otherwise a default message
     */
    private String extractMessageFromBody(Response response) {
        String defaultMessage = getDefaultMessageForStatus(response.status());
        if (response.body() != null) {
            try {
                // Reads the response body as a String
                String body = StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8);

                // Try parsing the JSON and extracting the "message" field
                JsonNode jsonNode = objectMapper.readTree(body);
                JsonNode messageNode = jsonNode.get("message");

                // Returns the value of the "message" field if present, otherwise returns a default message
                return messageNode != null ? messageNode.asText() : defaultMessage;
            } catch (IOException e) {
                e.printStackTrace();
                return defaultMessage;
            }
        }
        return defaultMessage;
    }

    /**
     * Returns a default message based on the provided HTTP status code.
     *
     * @param status the HTTP status code for which to get the default message
     * @return the default message corresponding to the HTTP status code
     */
    private String getDefaultMessageForStatus(int status) {
        switch (status) {
            case 400: return "Invalid request data.";
            case 401: return "Unauthorized access.";
            case 403: return "Access forbidden.";
            case 404: return "Resource not found.";
            case 409: return "Conflict - data may already exist.";
            case 500: return "Internal server error.";
            default: return "An unexpected error occurred.";
        }
    }
}
