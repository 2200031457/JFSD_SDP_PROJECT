package com.example.farmingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourcesController {

    // Resources page that lists articles, videos, and tips
    @GetMapping("/farmer/resources")
    public String showResourcesPage() {
        return "resources";  // Renders resources.html
    }

    // Mapping for articles page
    @GetMapping("/farmer/articles")
    public String showArticlesPage(Model model) {
        model.addAttribute("message", "Here are some valuable articles on agriculture.");
        return "articles";  // Renders articles.html
    }

    // Mapping for videos page
    @GetMapping("/farmer/videos")
    public String showVideosPage(Model model) {
        model.addAttribute("message", "Watch these videos to learn about farming.");
        return "videos";  // Renders videos.html
    }

    // Mapping for tips page
    @GetMapping("/farmer/tips")
    public String showTipsPage(Model model) {
        model.addAttribute("message", "Here are some helpful tips for farming.");
        return "tips";  // Renders tips.html
    }
}
