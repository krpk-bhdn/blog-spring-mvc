package com.example.blog.conrtoller;

import com.example.blog.entity.User;
import com.example.blog.factory.FactoryBCryptPasswordEncoder;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.FileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserRepository userRepository;
    private final FileService fileService;

    public ProfileController(
            UserRepository userRepository,
            FileService fileService
    ) {
        this.userRepository = userRepository;
        this.fileService = fileService;
    }

    @GetMapping
    public String profile(
            @AuthenticationPrincipal User user,
            Model model
    ){
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/settings")
    public String settings(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "settings";
    }

    @PostMapping("/settings/changeAvatar")
    public String changeAvatar(
            @AuthenticationPrincipal User user,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        user.setFilename(fileService.uploadFile(file, true));
        userRepository.save(user);
        return "redirect:/profile";
    }

    @PostMapping("/settings/changeUsername")
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

    @PostMapping("/settings/changePassword")
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
