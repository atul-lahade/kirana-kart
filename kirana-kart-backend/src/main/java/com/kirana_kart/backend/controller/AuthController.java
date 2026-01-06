package com.kirana_kart.backend.controller;

import com.kirana_kart.backend.constants.CommonErrorCodes;
import com.kirana_kart.backend.model.dto.request.LoginRequest;
import com.kirana_kart.backend.model.dto.request.RegisterRequest;
import com.kirana_kart.backend.model.dto.response.AuthResponse;
import com.kirana_kart.backend.model.dto.response.Response;
import com.kirana_kart.backend.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<@NonNull Response<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse authResponse = authService.register(request);

        Response<AuthResponse> response = Response.<AuthResponse>builder()
                .message(CommonErrorCodes.SUCCESS.getDescription())
                .status(HttpStatus.OK.value())
                .data(authResponse).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public ResponseEntity<@NonNull Response<AuthResponse>> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse authResponse = authService.login(request);
        Response<AuthResponse> response = Response.<AuthResponse>builder()
                .message(CommonErrorCodes.SUCCESS.getDescription())
                .status(HttpStatus.OK.value())
                .data(authResponse).build();
        return ResponseEntity.ok(response);
    }
}