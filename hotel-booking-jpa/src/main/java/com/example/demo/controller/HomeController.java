package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";  // resolves to /WEB-INF/views/home.jsp
    }
}
