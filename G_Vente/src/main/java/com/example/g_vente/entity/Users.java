package com.example.g_vente.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_user")
    private Long codeUser;

    @Column(length = 20, unique = true)
    private String login;

    @Column(length = 100)
    private String pass;


    public Users(Long codeUser, String login, String pass) {
        this.codeUser = codeUser;
        this.login = login;
        this.pass = pass;
    }

    public Users(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Users() {
    }

    public Long getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Long codeUser) {
        this.codeUser = codeUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}


