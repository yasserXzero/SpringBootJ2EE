package com.example.g_vente.controller;

import com.example.g_vente.repository.CommandeRepository;
import com.example.g_vente.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class FactureController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/facture")
    public ResponseEntity<byte[]> facture(@RequestParam Long id, @RequestParam String token) {
        var cmd = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));

        byte[] pdf = pdfService.generateFacture(cmd);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("facture_" + id + ".pdf").build());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
