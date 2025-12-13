package com.example.g_vente.dto;

public class CommandeRequestDTO {
    private Long codeCmd;
    private String client;
    private Long codePdt;
    private Long qteCmd;

    public CommandeRequestDTO() {}

    public Long getCodeCmd() { return codeCmd; }
    public void setCodeCmd(Long codeCmd) { this.codeCmd = codeCmd; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public Long getCodePdt() { return codePdt; }
    public void setCodePdt(Long codePdt) { this.codePdt = codePdt; }

    public Long getQteCmd() { return qteCmd; }
    public void setQteCmd(Long qteCmd) { this.qteCmd = qteCmd; }
}
