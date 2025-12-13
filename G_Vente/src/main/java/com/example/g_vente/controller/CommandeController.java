package com.example.g_vente.controller;

import com.example.g_vente.dto.CommandeRequestDTO;
import com.example.g_vente.service.ProduitStockService;
import com.example.g_vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommandeController {

    @Autowired
    private ProduitStockService produitStockService;

    @Autowired
    private VenteService venteService;

    @GetMapping("/commande")
    public String formCommande(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        model.addAttribute("produits", produitStockService.getAllProduitsStock());
        model.addAttribute("cmd", new CommandeRequestDTO());
        return "commande_form";
    }

    @PostMapping("/commande")
    public String submitCommande(@RequestParam String token,
                                 @ModelAttribute("cmd") CommandeRequestDTO cmd,
                                 Model model) {
        try {
            var saved = venteService.creerCommande(cmd);
            // redirect to PDF invoice
            return "redirect:/facture?id=" + saved.getId() + "&token=" + token;
        } catch (RuntimeException ex) {
            model.addAttribute("token", token);
            model.addAttribute("produits", produitStockService.getAllProduitsStock());
            model.addAttribute("error", ex.getMessage());
            return "commande_form";
        }
    }
}
