package com.example.student.management.system.Controller;

import com.example.student.management.system.Model.User;
import com.example.student.management.system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired
    UserService service;

    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        Optional<User> user = service.getUserByEmail(principal.getName());

        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }

        return "dashboard";
    }

    @GetMapping("/profile")
    public String showProfile(Model model,Principal principal){
        Optional<User> user = service.getUserByEmail(principal.getName());
        if(user.isPresent()){
            model.addAttribute("user",user.get());
        }
        return "profile";
    }

}
