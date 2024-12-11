package com.example.farmingapp.service;

import com.example.farmingapp.entity.Farmer;
import com.example.farmingapp.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    // Register a new farmer
    public Farmer registerFarmer(Farmer farmer) {
        return farmerRepository.save(farmer); // Save method works when JpaRepository is extended
    }

    // Login logic for farmer
    public Farmer loginFarmer(String email, String password) {
        Farmer farmer = farmerRepository.findByEmail(email); // Custom query
        if (farmer != null && farmer.getPassword().equals(password)) {
            return farmer; // Return farmer details if authentication is successful
        }
        return null; // Return null if authentication fails
    }

    // Get farmer by email
    public Farmer getFarmerByEmail(String email) {
        return farmerRepository.findByEmail(email); // Retrieve farmer details by email
    }

	
}
