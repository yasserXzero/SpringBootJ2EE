package com.example.g_vente.controller;

import com.example.g_vente.security.JwtUtil;
import com.example.g_vente.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping
    public String loginPage() {
        return "login";
    }
    @PostMapping
    public String authenticate(@RequestParam String login, @RequestParam String password, Model model) {

        if (usersService.verifyUser(login, password)) {

            String token = jwtUtil.generateToken(login);

            model.addAttribute("user", login);
            model.addAttribute("token", token);

            return "accueil";
        }

        model.addAttribute("error", "Login ou mot de passe incorrect");
        return "login";
    }
}
