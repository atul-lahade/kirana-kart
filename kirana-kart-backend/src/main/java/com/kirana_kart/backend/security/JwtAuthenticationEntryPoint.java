package com.kirana_kart.backend.security;

import com.kirana_kart.backend.model.dto.response.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * JWT Authentication Entry Point
 * Handles authentication errors and returns standardized JSON error responses
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    private final ObjectMapper objectMapper;

    public JwtAuthenticationEntryPoint() {
        this.objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        // Log the unauthorized access attempt
        logger.error("Unauthorized access attempt - IP: {}, URI: {}, Message: {}",
                request.getRemoteAddr(),
                request.getRequestURI(),
                authException.getMessage());

        // Set response headers
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");

        // Determine the error message
        String errorMessage = determineErrorMessage(request, authException);

        // Build error response
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpServletResponse.SC_UNAUTHORIZED)
                .error("Unauthorized")
                .message(errorMessage)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .details("Full authentication is required to access this resource")
                .build();

        // Write JSON response
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }

    /**
     * Determine appropriate error message based on request attributes
     */
    private String determineErrorMessage(HttpServletRequest request, AuthenticationException authException) {
        String errorAttribute = (String) request.getAttribute("error");

        if (errorAttribute != null) {
            return switch (errorAttribute) {
                case "invalid_token" -> "Invalid or malformed JWT token";
                case "expired_token" -> "JWT token has expired";
                case "unsupported_token" -> "Unsupported JWT token";
                case "empty_claims" -> "JWT claims string is empty";
                default -> "Authentication failed: " + authException.getMessage();
            };
        }

        return authException.getMessage() != null
                ? authException.getMessage()
                : "Full authentication is required to access this resource";
    }
}