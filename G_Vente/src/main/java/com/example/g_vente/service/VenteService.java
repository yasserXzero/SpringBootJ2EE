package com.example.g_vente.service;

import com.example.g_vente.dto.CommandeRequestDTO;
import com.example.g_vente.dto.TousCommandeDTO;
import com.example.g_vente.entity.Commande;
import com.example.g_vente.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Date;

@Service
public class VenteService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommandeRepository commandeRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String STOCK_SOUSTRAIRE_URL =
            "http://localhost:8082/stock/soustraire?codePdt={codePdt}&qteCmd={qteCmd}";

    private final String COMMERCIAL_ADD_CMD_URL =
            "http://localhost:8081/commercial/commande";

    @Transactional
    public Commande creerCommande(CommandeRequestDTO req) {

        Date now = new Date();

        // 1) Subtract stock (gestion_stock) FIRST
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

        // 2) Save in gestion_vente database (commandes) SECOND (generates codeCmd)
        Commande cmd = new Commande(req.getClient(), req.getCodePdt(), req.getQteCmd(), now);
        cmd = commandeRepository.save(cmd);

        if (cmd.getCodeCmd() == null) {

            cmd = commandeRepository.saveAndFlush(cmd);
        }


        TousCommandeDTO dto = new TousCommandeDTO(
                cmd.getCodeCmd(),
                cmd.getClient(),
                cmd.getCodePdt(),
                cmd.getQteCmd(),
                cmd.getDateCmd()
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

        return cmd;
    }

    private String extractApiMessage(String responseBody, String fallback) {
        if (responseBody == null || responseBody.isBlank()) return fallback;
        try {
            JsonNode node = objectMapper.readTree(responseBody);
            String msg = node.path("message").asText();
            return (msg == null || msg.isBlank()) ? fallback : msg;
        } catch (Exception e) {
            return fallback;
        }
    }
}
