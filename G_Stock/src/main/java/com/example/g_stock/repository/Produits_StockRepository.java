package com.example.g_stock.repository;

import com.example.g_stock.entity.Produits_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Produits_StockRepository extends JpaRepository<Produits_Stock, Long> {

    Produits_Stock findByCodePdt(Long codePdt);
}