package com.example.EmployeeLiveProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Render login.html (or login.jsp)
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error"; // Render error.html (or error.jsp)
    }
}

