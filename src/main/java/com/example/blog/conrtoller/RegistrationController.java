package com.example.blog.conrtoller;

import com.example.blog.entity.User;
import com.example.blog.factory.FactoryBCryptPasswordEncoder;
import com.example.blog.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    public final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){

        PasswordEncoder passwordEncoder = FactoryBCryptPasswordEncoder.getInstance();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (!userService.addUser(user)){
            model.addAttribute("message", "User is exist");
            return "registration";
        }

        return "redirect:/";
    }
}
