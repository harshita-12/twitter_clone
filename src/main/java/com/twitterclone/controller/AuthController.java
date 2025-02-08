package com.twitterclone.controller;

import com.twitterclone.model.User;
import com.twitterclone.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";  // Redirect if already logged in
        }
        return "login";
    }

    // Handle Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, 
                            @RequestParam String password, 
                            HttpSession session, 
                            Model model) {
        User user = userService.loginUser(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid username or password!");
        return "login";
    }

    // Show Registration Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Handle Registration
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, 
                               @RequestParam String password, 
                               @RequestParam String gender, 
                               Model model) {
        User user = userService.registerUser(username, password, gender);
        if (user == null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        return "redirect:/auth/login";
    }

    // Handle Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}
