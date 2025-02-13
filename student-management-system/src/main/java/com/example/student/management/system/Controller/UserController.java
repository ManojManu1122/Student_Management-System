package com.example.student.management.system.Controller;

import com.example.student.management.system.Model.User;
import com.example.student.management.system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute User user, Model model) {
        if (service.isEmailExists(user.getEmail())) {
            model.addAttribute("errorMessage", "User already exists with this email!");
            return "signup";
        }

        service.registerUser(user);

        model.addAttribute("successMessage", "Account created successfully! Please login.");
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password,Model model){
//        boolean isAuthenticated = service.authenticate(username,password);
//        if(isAuthenticated){
//            return "redirect:/dashboard";
//        }
//        else {
//            model.addAttribute("error","Invalid Username and Password");
//            return "login";
//        }
//
//    }


}
