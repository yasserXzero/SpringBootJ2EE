package com.example.g_vente.service;

import com.example.g_vente.entity.Commande;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generateFacture(Commande cmd) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, out);

            document.open();

            document.add(new Paragraph("FACTURE COMMANDE"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Code Commande: " + cmd.getCodeCmd()));
            document.add(new Paragraph("Client: " + cmd.getClient()));
            document.add(new Paragraph("Code Produit: " + cmd.getCodePdt()));
            document.add(new Paragraph("Quantite: " + cmd.getQteCmd()));
            document.add(new Paragraph("Date: " + cmd.getDateCmd()));

            document.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed: " + e.getMessage());
        }
    }
}
