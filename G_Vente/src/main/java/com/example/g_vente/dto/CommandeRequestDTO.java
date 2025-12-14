package com.example.g_vente.dto;

public class CommandeRequestDTO {
    private String client;
    private Long codePdt;
    private Long qteCmd;

    public CommandeRequestDTO() {}

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public Long getCodePdt() { return codePdt; }
    public void setCodePdt(Long codePdt) { this.codePdt = codePdt; }

    public Long getQteCmd() { return qteCmd; }
    public void setQteCmd(Long qteCmd) { this.qteCmd = qteCmd; }
}
