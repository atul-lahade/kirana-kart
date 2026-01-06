package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.PasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasswordTokenRepository extends JpaRepository<PasswordToken, UUID> {
}
