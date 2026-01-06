package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, UUID> {
}
