package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductReviewRepository extends JpaRepository<ProductReview, UUID> {
}
