package com.example.farmingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarketPriceController {

    // Method to fetch market prices
    @GetMapping("/farmer/market-prices")
    public String getMarketPrices(@RequestParam(name = "crop", required = false) String crop, Model model) {
        // If no crop is provided, set a default crop
        if (crop == null || crop.isEmpty()) {
            crop = "Wheat"; // Default crop
        }

        // Fetch price from a placeholder method (replace with actual API call)
        String price = fetchMarketPrice(crop);
        
        // Adding attributes to the model
        model.addAttribute("cropName", crop);
        model.addAttribute("price", price);
        
        // Return the view (HTML page)
        return "market_prices";  // market_prices.html will display the prices
    }

    // Placeholder method to simulate fetching market price
    private String fetchMarketPrice(String crop) {
        // Replace this logic with actual API call to get the market price
        if (crop.equalsIgnoreCase("Wheat")) {
            return "500"; // Example price in local currency
        } else if (crop.equalsIgnoreCase("Rice")) {
            return "600";
        }
        return "Not Available"; // Default response for unknown crops
    }
}
