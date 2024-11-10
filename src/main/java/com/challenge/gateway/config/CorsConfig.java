package com.challenge.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures Cross-Origin Resource Sharing (CORS) settings for the application.
 * Implements the {@code WebMvcConfigurer} interface to provide CORS mappings.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configures the CORS (Cross-Origin Resource Sharing) mappings for the application,
     * allowing cross-origin requests from specific origins with specified methods and headers.
     *
     * @param registry the {@code CorsRegistry} to configure the CORS mappings
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://calc-front-eta.vercel.app/",
                        "https://calculator-chanllenge.vercel.app/"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}