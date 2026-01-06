package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.Inventory;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<@NonNull Inventory, @NonNull Long> {
}
