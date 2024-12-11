package com.example.farmingapp.service;

import com.example.farmingapp.entity.Admin;
import com.example.farmingapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Authenticate an admin using email and password.
     */
    public boolean authenticate(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }

    /**
     * Register a new admin.
     */
    public Admin registerAdmin(Admin admin) {
        // Encode the password before saving
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}
