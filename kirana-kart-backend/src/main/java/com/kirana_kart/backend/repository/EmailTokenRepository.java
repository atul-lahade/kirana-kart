package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailTokenRepository extends JpaRepository<EmailToken, UUID> {
}
