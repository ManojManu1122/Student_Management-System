package com.example.student.management.system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Student Management System");
        model.addAttribute("description", "A complete student management system with CRUD operations, authentication, and PostgreSQL integration.");
        return "home";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/signup")
//    public String signup() {
//        return "signup";
//    }
}
