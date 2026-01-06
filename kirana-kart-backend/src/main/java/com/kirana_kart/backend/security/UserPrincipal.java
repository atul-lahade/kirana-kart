package com.kirana_kart.backend.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kirana_kart.backend.model.entity.User;
import com.kirana_kart.backend.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Custom UserDetails implementation
 * Represents the authenticated user in Spring Security context
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    @JsonIgnore
    private String password;

    private UserRole role;

    private boolean emailVerified;

    private boolean active;

    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Create UserPrincipal from User entity
     *
     * @param user User entity
     * @return UserPrincipal instance
     */
    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );

        return new UserPrincipal(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getEmailVerified(),
                user.getIsActive(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active && emailVerified;
    }

    /**
     * Get full name
     *
     * @return full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Check if user has specific role
     *
     * @param role role to check
     * @return true if user has role, false otherwise
     */
    public boolean hasRole(UserRole role) {
        return this.role == role;
    }

    /**
     * Check if user is admin
     *
     * @return true if user is admin, false otherwise
     */
    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }

    /**
     * Check if user is customer
     *
     * @return true if user is customer, false otherwise
     */
    public boolean isCustomer() {
        return this.role == UserRole.CUSTOMER;
    }
}