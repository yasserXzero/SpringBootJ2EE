package com.example.g_vente.controller;

import com.example.g_vente.security.JwtUtil;
import com.example.g_vente.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
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
                               HttpServletRequest request,
                               Model model) {

        if (usersService.verifyUser(login, password)) {
            String token = jwtUtil.generateToken(login);

            HttpSession session = request.getSession(true);
            session.setAttribute("JWT", token);
            session.setAttribute("USER", login);

            // No token in model anymore
            model.addAttribute("user", login);

            return "accueil";
        }

        model.addAttribute("error", "Login ou mot de passe incorrect");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        return "redirect:/auth";
    }
}
