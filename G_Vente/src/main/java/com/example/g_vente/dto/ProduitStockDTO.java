package com.example.g_vente.dto;


public class ProduitStockDTO {

    private Long codePdt;
    private String nomPdt;
    private Long prixPdt;
    private Long qtePdt;

    public ProduitStockDTO() {}

    public ProduitStockDTO(Long codePdt, String nomPdt, Long prixPdt, Long qtePdt) {
        this.codePdt = codePdt;
        this.nomPdt = nomPdt;
        this.prixPdt = prixPdt;
        this.qtePdt = qtePdt;
    }

    public Long getCodePdt() {
        return codePdt;
    }

    public String getNomPdt() {
        return nomPdt;
    }

    public Long getPrixPdt() {
        return prixPdt;
    }

    public Long getQtePdt() {
        return qtePdt;
    }
}
