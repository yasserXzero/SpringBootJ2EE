package com.example.g_vente.controller;

import com.example.g_vente.dto.CommandeRequestDTO;
import com.example.g_vente.service.ProduitStockService;
import com.example.g_vente.service.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommandeController {

    private final ProduitStockService produitStockService;
    private final VenteService venteService;

    public CommandeController(ProduitStockService produitStockService, VenteService venteService) {
        this.produitStockService = produitStockService;
        this.venteService = venteService;
    }

    @GetMapping("/commande")
    public String formCommande(Model model) {
        model.addAttribute("produits", produitStockService.getAllProduitsStock());
        model.addAttribute("cmd", new CommandeRequestDTO());
        return "commande_form";
    }

    @PostMapping("/commande")
    public String submitCommande(@ModelAttribute("cmd") CommandeRequestDTO cmd, Model model) {
        try {
            var saved = venteService.creerCommande(cmd);

            // Go to success page that will open facture in new tab and return to accueil
            return "redirect:/commande/success?id=" + saved.getCodeCmd();

        } catch (RuntimeException ex) {
            model.addAttribute("produits", produitStockService.getAllProduitsStock());
            model.addAttribute("error", ex.getMessage());
            return "commande_form";
        }
    }

    @GetMapping("/commande/success")
    public String success(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "commande_success";
    }

}
