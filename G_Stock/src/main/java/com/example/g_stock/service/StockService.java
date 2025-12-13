package com.example.g_stock.service;

import com.example.g_stock.entity.Produits_Stock;
import com.example.g_stock.repository.Produits_StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StockService {

    @Autowired
    private Produits_StockRepository produitsStockRepository;

    public Produits_Stock soustraireStock(Long codePdt, Long qteCmd) {

        Produits_Stock stock = produitsStockRepository.findByCodePdt(codePdt);

        if (stock == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé dans le stock");  }

        if (stock.getQtePdt() < qteCmd) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Quantité insuffisante en stock");
        }

        stock.setQtePdt(stock.getQtePdt() - qteCmd);
        return produitsStockRepository.save(stock);
    }
}
