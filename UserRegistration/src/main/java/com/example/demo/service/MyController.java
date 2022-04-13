package com.example.demo.service;

import com.example.demo.security.User;
import com.example.demo.security.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MyController {

    private UserRepository userRepository;

    public MyController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public String greeting(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("username", principal.getName());
        model.addAttribute("firstName", user.getFirstName());
        return "hello";
    }
}
