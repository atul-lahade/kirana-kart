package com.kirana_kart.backend.service;

import com.kirana_kart.backend.exception.custom.UserNotFoundException;
import com.kirana_kart.backend.model.entity.User;
import com.kirana_kart.backend.repository.UserRepository;
import com.kirana_kart.backend.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Custom UserDetailsService implementation for Spring Security
 * Loads user-specific data for authentication and authorization
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final UserRepository userRepository;

    /**
     * Load user by username (email in our case)
     * This method is called by Spring Security during authentication
     *
     * @param email user's email address
     * @return UserDetails object containing user information
     * @throws UsernameNotFoundException if user is not found
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("Loading user by email: {}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.error("User not found with email: {}", email);
                    return new UsernameNotFoundException("User not found with email: " + email);
                });

        logger.debug("User found: {} with role: {}", user.getEmail(), user.getRole());

        return UserPrincipal.create(user);
    }

    /**
     * Load user by user ID
     * Used by JWT authentication filter
     *
     * @param userId user's UUID
     * @return UserDetails object containing user information
     * @throws UserNotFoundException if user is not found
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserById(String userId) {
        logger.debug("Loading user by ID: {}", userId);

        User user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", userId);
                    return new UserNotFoundException(userId);
                });

        logger.debug("User found: {} (ID: {})", user.getEmail(), user.getId());

        return UserPrincipal.create(user);
    }

    /**
     * Load user by user ID (UUID type)
     *
     * @param userId user's UUID
     * @return UserDetails object containing user information
     * @throws UserNotFoundException if user is not found
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserById(UUID userId) {
        logger.debug("Loading user by UUID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    logger.error("User not found with UUID: {}", userId);
                    return new UserNotFoundException(userId.toString());
                });

        logger.debug("User found: {} (UUID: {})", user.getEmail(), user.getId());

        return UserPrincipal.create(user);
    }

    /**
     * Check if user exists by email
     *
     * @param email user's email
     * @return true if user exists, false otherwise
     */
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    /**
     * Check if user is verified
     *
     * @param email user's email
     * @return true if user is verified, false otherwise
     */
    @Transactional(readOnly = true)
    public boolean isUserVerified(String email) {
        return userRepository.findByEmail(email)
                .map(User::getEmailVerified)
                .orElse(false);
    }

    /**
     * Check if user account is active
     *
     * @param email user's email
     * @return true if user is active, false otherwise
     */
    @Transactional(readOnly = true)
    public boolean isUserActive(String email) {
        return userRepository.findByEmail(email)
                .map(User::getIsActive)
                .orElse(false);
    }
}