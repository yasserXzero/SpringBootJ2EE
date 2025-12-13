package com.example.g_stock.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produits_stock")
public class Produits_Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_stock")
    private Long codeStock;

    @Column(name = "code_pdt")
    private Long codePdt;

    @Column(name = "qte_pdt")
    private Long qtePdt;

    public Produits_Stock() {}

    public Produits_Stock(Long codePdt, Long qtePdt) {
        this.codePdt = codePdt;
        this.qtePdt = qtePdt;
    }

    public Long getCodeStock() {
        return codeStock;
    }

    public void setCodeStock(Long codeStock) {
        this.codeStock = codeStock;
    }

    public Long getCodePdt() {
        return codePdt;
    }

    public void setCodePdt(Long codePdt) {
        this.codePdt = codePdt;
    }

    public Long getQtePdt() {
        return qtePdt;
    }

    public void setQtePdt(Long qtePdt) {
        this.qtePdt = qtePdt;
    }
}