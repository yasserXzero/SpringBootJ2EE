package com.example.g_vente.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_cmd")
    private Long codeCmd;

    @Column(length = 20)
    private String client;

    @Column(name = "code_pdt")
    private Long codePdt;

    @Column(name = "qte_cmd")
    private Long qteCmd;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_cmd")
    private Date dateCmd;

    public Commande( String client, Long codePdt, Long qteCmd, Date dateCmd) {

        this.client = client;
        this.codePdt = codePdt;
        this.qteCmd = qteCmd;
        this.dateCmd = dateCmd;
    }

    public Commande(Long codeCmd, String client, Long codePdt, Long qteCmd, Date dateCmd) {
        this.codeCmd = codeCmd;
        this.client = client;
        this.codePdt = codePdt;
        this.qteCmd = qteCmd;
        this.dateCmd = dateCmd;
    }

    public Commande() {
    }



    public Long getCodeCmd() {
        return codeCmd;
    }

    public void setCodeCmd(Long codeCmd) {
        this.codeCmd = codeCmd;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getCodePdt() {
        return codePdt;
    }

    public void setCodePdt(Long codePdt) {
        this.codePdt = codePdt;
    }

    public Long getQteCmd() {
        return qteCmd;
    }

    public void setQteCmd(Long qteCmd) {
        this.qteCmd = qteCmd;
    }

    public Date getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(Date dateCmd) {
        this.dateCmd = dateCmd;
    }
}
