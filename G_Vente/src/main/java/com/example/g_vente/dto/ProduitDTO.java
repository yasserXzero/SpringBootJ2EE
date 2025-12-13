package com.example.g_vente.dto;

public class ProduitDTO {

    private Long codePdt;
    private String nomPdt;
    private Long prixPdt;

    public ProduitDTO() {}

    public Long getCodePdt() {
        return codePdt;
    }

    public void setCodePdt(Long codePdt) {
        this.codePdt = codePdt;
    }

    public String getNomPdt() {
        return nomPdt;
    }

    public void setNomPdt(String nomPdt) {
        this.nomPdt = nomPdt;
    }

    public Long getPrixPdt() {
        return prixPdt;
    }

    public void setPrixPdt(Long prixPdt) {
        this.prixPdt = prixPdt;
    }
}
