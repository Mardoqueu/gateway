package com.challenge.gateway.config;

import com.challenge.gateway.exception.CustomFeignErrorDecoder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Configuration class for setting up Feign clients.
 */
@Configuration
public class FeignConfig {

    /**
     * Creates a RequestInterceptor that intercepts outgoing Feign client requests and applies the
     * Authorization header from the incoming HTTP request, if present.
     *
     * @return a RequestInterceptor that adds the Authorization header to outgoing Feign requests.
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attributes != null) {
                    String authorization = attributes.getRequest().getHeader("Authorization");
                    if (authorization != null && !authorization.isEmpty()) {
                        template.header("Authorization", authorization);
                    }
                }
            }
        };
    }

    /**
     * Configures the custom error decoder to handle HTTP error responses from Feign clients.
     *
     * @return An instance of {@link CustomFeignErrorDecoder}, which processes HTTP responses and extracts
     *         error messages to throw appropriate exceptions based on the status code.
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
