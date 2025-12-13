package com.example.g_vente.service;

import com.example.g_vente.dto.CommandeRequestDTO;
import com.example.g_vente.dto.TousCommandeDTO;
import com.example.g_vente.entity.Commande;
import com.example.g_vente.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class VenteService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommandeRepository commandeRepository;


    private final String STOCK_SOUSTRAIRE_URL =
            "http://localhost:8082/stock/soustraire?codePdt={codePdt}&qteCmd={qteCmd}";

    private final String COMMERCIAL_ADD_CMD_URL =
            "http://localhost:8081/commercial/commande";

    public Commande creerCommande(CommandeRequestDTO req) {

        Date now = new Date();

        // 1) Subtract stock (gestion_stock)
        ResponseEntity<String> stockResp = restTemplate.exchange(
                STOCK_SOUSTRAIRE_URL,
                HttpMethod.POST,
                null,
                String.class,
                req.getCodePdt(),
                req.getQteCmd()
        );

        if (!stockResp.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Stock error: cannot subtract quantity.");
        }

        // 2) Insert line into Tous_commandes (gestion_commercial)
        TousCommandeDTO dto = new TousCommandeDTO(
                req.getCodeCmd(),
                req.getClient(),
                req.getCodePdt(),
                req.getQteCmd(),
                now
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TousCommandeDTO> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<String> commResp = restTemplate.exchange(
                COMMERCIAL_ADD_CMD_URL,
                HttpMethod.POST,
                entity,
                String.class
        );

        if (!commResp.getStatusCode().is2xxSuccessful()) {

            throw new RuntimeException("Commercial error: cannot insert Tous_commandes.");
        }

        // 3) Save in gestion_vente database (commandes)
        Commande cmd = new Commande(req.getCodeCmd(), req.getClient(), req.getCodePdt(), req.getQteCmd(), now);
        return commandeRepository.save(cmd);
    }
}
