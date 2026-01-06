package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, UUID> {
}
