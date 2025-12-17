package com.example.g_vente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GVenteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GVenteApplication.class, args);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        //i did this bax ndakhalo f data base mcrypti


    }
}
