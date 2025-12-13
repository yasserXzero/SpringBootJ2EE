package com.example.g_vente.dto;

import java.util.Date;

public class TousCommandeDTO {
    private Long codeCmd;
    private String client;
    private Long codePdt;
    private Long qteCmd;
    private Date dateCmd;

    public TousCommandeDTO() {}

    public TousCommandeDTO(Long codeCmd, String client, Long codePdt, Long qteCmd, Date dateCmd) {
        this.codeCmd = codeCmd;
        this.client = client;
        this.codePdt = codePdt;
        this.qteCmd = qteCmd;
        this.dateCmd = dateCmd;
    }

    public Long getCodeCmd() { return codeCmd; }
    public void setCodeCmd(Long codeCmd) { this.codeCmd = codeCmd; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public Long getCodePdt() { return codePdt; }
    public void setCodePdt(Long codePdt) { this.codePdt = codePdt; }

    public Long getQteCmd() { return qteCmd; }
    public void setQteCmd(Long qteCmd) { this.qteCmd = qteCmd; }

    public Date getDateCmd() { return dateCmd; }
    public void setDateCmd(Date dateCmd) { this.dateCmd = dateCmd; }
}
