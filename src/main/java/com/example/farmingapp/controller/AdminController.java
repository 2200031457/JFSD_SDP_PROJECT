package com.example.farmingapp.controller;

import com.example.farmingapp.entity.Admin;
import com.example.farmingapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Display the Admin Login Page.
     */
    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin_login";
    }

    /**
     * Handle Admin Login Logic (to be implemented with security properly).
     */
    @PostMapping("/admin/login")
    public String loginAdmin(String email, String password) {
        // Implement admin authentication logic securely here
        if (adminService.authenticate(email, password)) {
            return "redirect:/admin/login?error=true";
        } else {
            return "redirect:/dashboard";
        }
    }
    
    /**
     * Display Admin Signup Page.
     */
    @GetMapping("/admin/signup")
    public String showAdminSignupPage() {
        return "admin_signup";
    }

    /**
     * Handle Admin Registration.
     */
    @PostMapping("/admin/signup")
    public String registerAdmin(Admin admin) {
        adminService.registerAdmin(admin);
        return "redirect:/admin/login";
    }

    /**
     * Display the Admin Dashboard.
     */
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // Get authenticated admin email
        model.addAttribute("email", email);
        return "admin-dashboard";
    }
   
}
