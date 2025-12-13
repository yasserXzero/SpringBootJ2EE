package com.example.g_vente.controller;

import com.example.g_vente.repository.CommandeRepository;
import com.example.g_vente.service.PdfService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class FactureController {

    private final CommandeRepository commandeRepository;
    private final PdfService pdfService;

    public FactureController(CommandeRepository commandeRepository, PdfService pdfService) {
        this.commandeRepository = commandeRepository;
        this.pdfService = pdfService;
    }

    @GetMapping("/facture")
    public ResponseEntity<byte[]> facture(@RequestParam Long id) {
        var cmd = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));

        byte[] pdf = pdfService.generateFacture(cmd);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("facture_" + id + ".pdf").build());
        headers.setCacheControl(CacheControl.noStore());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
