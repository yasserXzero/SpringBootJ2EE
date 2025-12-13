package com.example.g_stock.restcontroller;

import com.example.g_stock.entity.Produits_Stock;
import com.example.g_stock.repository.Produits_StockRepository;

import com.example.g_stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private Produits_StockRepository produitsStockRepository;
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Produits_Stock> getAllStock() {
        return produitsStockRepository.findAll();
    }
    @PostMapping("/soustraire")
    public Produits_Stock soustraireStock(@RequestParam Long codePdt, @RequestParam Long qteCmd) {
        return stockService.soustraireStock(codePdt, qteCmd);
    }
}
