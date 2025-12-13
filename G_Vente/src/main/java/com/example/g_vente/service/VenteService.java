package com.example.g_vente.service;

import com.example.g_vente.dto.CommandeRequestDTO;
import com.example.g_vente.dto.TousCommandeDTO;
import com.example.g_vente.entity.Commande;
import com.example.g_vente.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
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

    public Commande creerCommande(CommandeRequestDTO req) {

        Date now = new Date();

        // 1) Subtract stock (gestion_stock)
        try {
            restTemplate.postForEntity(
                    STOCK_SOUSTRAIRE_URL,
                    null,
                    String.class,
                    req.getCodePdt(),
                    req.getQteCmd()
            );
        } catch (RestClientResponseException ex) {

            throw new RuntimeException(extractApiMessage(ex.getResponseBodyAsString(), "Erreur stock"));
        }

        // 2) Insert into commercial
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

        try {
            restTemplate.postForEntity(COMMERCIAL_ADD_CMD_URL, entity, String.class);
        } catch (RestClientResponseException ex) {
            throw new RuntimeException(extractApiMessage(ex.getResponseBodyAsString(), "Erreur commercial"));
        }

        // 3) Save locally
        Commande cmd = new Commande(req.getCodeCmd(), req.getClient(), req.getCodePdt(), req.getQteCmd(), now);
        return commandeRepository.save(cmd);
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
