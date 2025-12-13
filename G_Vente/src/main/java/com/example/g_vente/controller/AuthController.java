package com.example.g_vente.controller;

import com.example.g_vente.security.JwtUtil;
import com.example.g_vente.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final JwtUtil jwtUtil;

    public AuthController(UsersService usersService, JwtUtil jwtUtil) {
        this.usersService = usersService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping
    public String authenticate(@RequestParam String login,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {

        if (!usersService.verifyUser(login, password)) {
            model.addAttribute("error", "Login ou mot de passe incorrect");
            return "login";
        }

        String token = jwtUtil.generateToken(login);

        // Option A: keep token server-side
        session.setAttribute("user", login);
        session.setAttribute("token", token);

        return "redirect:/accueil";
    }
}
