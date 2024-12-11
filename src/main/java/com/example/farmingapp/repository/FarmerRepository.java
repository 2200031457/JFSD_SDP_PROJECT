package com.example.farmingapp.repository;

import com.example.farmingapp.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    Farmer findByEmail(String email);
}