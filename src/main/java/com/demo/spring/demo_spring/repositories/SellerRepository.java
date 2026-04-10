package com.demo.spring.demo_spring.repositories;

import com.demo.spring.demo_spring.entities.Seller;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Id> {
}
