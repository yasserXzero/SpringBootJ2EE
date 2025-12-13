package com.example.g_vente.controller;

import com.example.g_vente.service.ProduitStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitController {

    private final ProduitStockService produitStockService;

    public ProduitController(ProduitStockService produitStockService) {
        this.produitStockService = produitStockService;
    }

    @GetMapping("/produits")
    public String afficherProduits(Model model) {
        model.addAttribute("produits", produitStockService.getAllProduitsStock());
        return "produits";
    }
}
