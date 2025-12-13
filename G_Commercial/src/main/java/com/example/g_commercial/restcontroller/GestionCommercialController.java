package com.example.g_commercial.restcontroller;

import com.example.g_commercial.entity.Produits_Prix;
import com.example.g_commercial.entity.Tous_Commande;
import com.example.g_commercial.repository.Produits_PrixRepository;
import com.example.g_commercial.repository.Tous_CommandeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commercial")
public class GestionCommercialController {

    @Autowired
     Produits_PrixRepository produitsPrixRepository;
    @Autowired
     Tous_CommandeRepository tousCommandeRepository;

    @GetMapping("/produits")
    public List<Produits_Prix> getAllProduits() {
        return produitsPrixRepository.findAll();
    }

    @PostMapping("/commande")
    public Tous_Commande addCommande(@RequestBody Tous_Commande commande) {
        return tousCommandeRepository.save(commande);
    }
}


