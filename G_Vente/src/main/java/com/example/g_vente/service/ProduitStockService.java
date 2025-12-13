package com.example.g_vente.service;

import com.example.g_vente.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProduitStockService {

    @Autowired
    private RestTemplate restTemplate;

    private final String STOCK_URL = "http://localhost:8082/stock";
    private final String COMMERCIAL_URL = "http://localhost:8081/commercial/produits";

    public List<ProduitStockDTO> getAllProduitsStock() {

        StockDTO[] stocks = restTemplate.getForObject(STOCK_URL, StockDTO[].class);
        ProduitDTO[] produits = restTemplate.getForObject(COMMERCIAL_URL, ProduitDTO[].class);

        Map<Long, ProduitDTO> produitMap = new HashMap<>();
        for (ProduitDTO p : produits) {
            produitMap.put(p.getCodePdt(), p);
        }

        List<ProduitStockDTO> result = new ArrayList<>();

        for (StockDTO s : stocks) {
            ProduitDTO p = produitMap.get(s.getCodePdt());
            if (p != null) {
                result.add(new ProduitStockDTO(
                        s.getCodePdt(),
                        p.getNomPdt(),
                        p.getPrixPdt(),
                        s.getQtePdt()
                ));
            }
        }

        return result;
    }
}
