package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, UUID> {
}
