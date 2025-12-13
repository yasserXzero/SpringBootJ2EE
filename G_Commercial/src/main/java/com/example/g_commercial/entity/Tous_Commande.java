package com.example.g_commercial.entity;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "tous_commandes")
public class Tous_Commande {

    @Id
    @Column(name = "code_tous_cmd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeTousCmd;

    @Column(name = "code_cmd")
    private Long codeCmd;

    @Column(name = "client", length = 20)
    private String client;

    @Column(name = "code_pdt")
    private Long codePdt;

    @Column(name = "qte_cmd")
    private Long qteCmd;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_cmd")
    private Date dateCmd;

    public Tous_Commande(Long codeCmd, String client, Long codePdt, Long qteCmd, Date dateCmd) {
        this.codeCmd = codeCmd;
        this.client = client;
        this.codePdt = codePdt;
        this.qteCmd = qteCmd;
        this.dateCmd = dateCmd;
    }
    public Tous_Commande() {}

    public Tous_Commande(Long codeTousCmd, Long codeCmd, String client, Long codePdt, Long qteCmd, Date dateCmd) {
        this.codeTousCmd = codeTousCmd;
        this.codeCmd = codeCmd;
        this.client = client;
        this.codePdt = codePdt;
        this.qteCmd = qteCmd;
        this.dateCmd = dateCmd;
    }

    public Long getCodeTousCmd() {
        return codeTousCmd;
    }

    public void setCodeTousCmd(Long codeTousCmd) {
        this.codeTousCmd = codeTousCmd;
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
