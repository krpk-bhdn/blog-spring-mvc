package com.example.blog.conrtoller;

import com.example.blog.entity.User;
import com.example.blog.factory.FactoryBCryptPasswordEncoder;
import com.example.blog.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String profile(
            @AuthenticationPrincipal User user,
            Model model
    ){
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("changeUsername")
    public String changeUsername(
            @RequestParam String username,
            @AuthenticationPrincipal User user
    ){
        if(username != null && !username.isEmpty() && !user.getUsername().equals(username)){
            user.setUsername(username);
            userRepository.save(user);
        }

        return "redirect:/profile";
    }

    @PostMapping("changePassword")
    public String changePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            @AuthenticationPrincipal User user
    ){
        PasswordEncoder passwordEncoder = FactoryBCryptPasswordEncoder.getInstance();
        if (
                oldPassword != null
                        && !oldPassword.isEmpty()
                        && newPassword != null
                        && !newPassword.isEmpty()
                        && !oldPassword.equals(newPassword)
        ){
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        }

        return "redirect:/profile";
    }
}
