package com.example.g_vente.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AccueilController {

    @GetMapping("/accueil")
    public String accueil(Model model, Principal principal, HttpSession session) {
        String user = (principal != null) ? principal.getName() : (String) session.getAttribute("USER");
        model.addAttribute("user", user);
        return "accueil";
    }
}
