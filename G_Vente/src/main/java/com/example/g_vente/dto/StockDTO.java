package com.example.g_vente.dto;

public class StockDTO {

    private Long codePdt;
    private Long qtePdt;

    public StockDTO() {}

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
