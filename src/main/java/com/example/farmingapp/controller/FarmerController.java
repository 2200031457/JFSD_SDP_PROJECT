package com.example.farmingapp.controller;

import com.example.farmingapp.entity.Farmer;
import com.example.farmingapp.service.FarmerService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FarmerController {
	

	   

    @Autowired
    private FarmerService farmerService;
    
    @GetMapping("/weather")
    public String showWeatherPage() {
        return "weather"; // Renders weather.html
    }

    @GetMapping("/market-prices")
    public String showMarketPricesPage() {
        return "market_prices"; // Renders market_prices.html
    }

    @GetMapping("/resources")
    public String showResourcesPage() {
        return "resources"; // Renders resources.html
    }

   
    @GetMapping("/farmer/login")
    public String showFarmerLoginPage() {
        return "farmer_login";  // renders farmer_login.html
    }

    @PostMapping("/farmer/login")
    public String loginFarmer(String email, String password) {
        // Your login logic here, possibly redirect to farmer dashboard
        return "farmer_dashboard";  // Redirect to dashboard
    }

    @GetMapping("/farmer/signup")
    public String showFarmerSignupPage() {
        return "farmer_signup";  // renders farmer_signup.html
    }

    @PostMapping("/farmer/signup")
    public String registerFarmer(Farmer farmer) {
        farmerService.registerFarmer(farmer);
        return "farmer_login";  // Redirect to login page after signup
    }
    @GetMapping("/farmer/logout")
    public String logoutFarmer() {
        // Redirect directly to the login page
        return "redirect:/farmer/login";
    }
    @GetMapping("/contact")
    public String showContactPage() {
        return "contactus";  // Renders contactus.html
    }

    @PostMapping("/submit-contact")
    public String submitContactForm(String name, String email, String message) {
        // Add logic to handle the form submission
        System.out.println("Name: " + name + ", Email: " + email + ", Message: " + message);
        return "contactus";  // Redirect or show a confirmation page
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "about_us"; // Ensure the name matches the template file
    }


    @PostMapping("/submit-feedback")
    public String submitFeedback(@RequestParam String name, @RequestParam String email, @RequestParam String feedback) {
        // Add logic to handle feedback submission
        System.out.println("Feedback received from " + name + " (" + email + "): " + feedback);
        return "aboutus"; // Redirect or show a confirmation page
    }


}