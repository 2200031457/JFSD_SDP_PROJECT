package com.example.farmingapp.controller;

import com.example.farmingapp.entity.WeatherResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    private final String apiKey = "f577d4d503dc49fb82470239243105"; // WeatherAPI key

    @GetMapping("/farmer/weather")
    public String getWeather(@RequestParam(name = "location", required = false) String location, Model model) {
        String url = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + (location != null ? location : "London");
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        if (weatherResponse != null && weatherResponse.getLocation() != null && weatherResponse.getCurrent() != null) {
            model.addAttribute("location", weatherResponse.getLocation().getName());
            model.addAttribute("temperature", weatherResponse.getCurrent().getTempC());
            model.addAttribute("condition", weatherResponse.getCurrent().getCondition().getText());
            model.addAttribute("humidity", weatherResponse.getCurrent().getHumidity());
            model.addAttribute("windSpeed", weatherResponse.getCurrent().getWindKph());
        } else {
            model.addAttribute("error", "Could not fetch weather data.");
        }

        return "weather";  // renders the weather.html page
    }
}
