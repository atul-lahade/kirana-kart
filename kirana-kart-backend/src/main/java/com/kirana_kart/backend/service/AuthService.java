package com.kirana_kart.backend.service;

import com.kirana_kart.backend.exception.custom.EmailAlreadyExistsException;
import com.kirana_kart.backend.exception.custom.InvalidCredentialsException;
import com.kirana_kart.backend.model.dto.request.LoginRequest;
import com.kirana_kart.backend.model.dto.request.RegisterRequest;
import com.kirana_kart.backend.model.dto.response.AuthResponse;
import com.kirana_kart.backend.model.dto.response.UserDTO;
import com.kirana_kart.backend.model.entity.User;
import com.kirana_kart.backend.model.enums.UserRole;
import com.kirana_kart.backend.repository.UserRepository;
import com.kirana_kart.backend.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final GenericMapper modelMapper;

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        log.info("Registering new user with email: {}", request.getEmail());

        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            throw new EmailAlreadyExistsException("Email already registered: " + request.getEmail());
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .role(UserRole.CUSTOMER)
                .isActive(true)
                .emailVerified(false)
                .build();

        user = userRepository.save(user);

        String accessToken = jwtTokenProvider.generateToken(convertToUserDetails(user));
        String refreshToken = jwtTokenProvider.generateRefreshToken(convertToUserDetails(user));

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn(86400000L) // 24 hours
                .user(modelMapper.mapToDto(user, UserDTO.class))
                .build();
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        log.info("User login attempt: {}", request.getEmail());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

            String accessToken = jwtTokenProvider.generateToken(userDetails);
            String refreshToken = jwtTokenProvider.generateRefreshToken(userDetails);

            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .tokenType("Bearer")
                    .expiresIn(86400000L)
                    .user(modelMapper.mapToDto(user, UserDTO.class))
                    .build();

        } catch (Exception e) {
            log.error("Authentication failed for user: {}", request.getEmail());
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }

    private UserDetails convertToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}