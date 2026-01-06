package com.kirana_kart.backend.repository;

import com.kirana_kart.backend.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
