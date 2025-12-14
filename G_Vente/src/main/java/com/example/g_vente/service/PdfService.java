package com.example.g_vente.service;

import com.example.g_vente.entity.Commande;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;

@Service
public class PdfService {

    private static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public byte[] generateFacture(Commande cmd) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Font hFont     = new Font(Font.HELVETICA, 11, Font.BOLD);
            Font txtFont   = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Font smallFont = new Font(Font.HELVETICA, 9, Font.NORMAL);

            // ===== HEADER (Company + Invoice Title) =====
            PdfPTable header = new PdfPTable(2);
            header.setWidthPercentage(100);
            header.setWidths(new float[]{70, 30});

            PdfPCell companyCell = new PdfPCell();
            companyCell.setBorder(Rectangle.NO_BORDER);
            companyCell.addElement(new Paragraph("G_Vente", hFont));
            companyCell.addElement(new Paragraph("Adresse: Tanger, Maroc", txtFont));
            companyCell.addElement(new Paragraph("Tél: +212 6xx xx xx xx", txtFont));
            companyCell.addElement(new Paragraph("Email: Yasser_kharroub@Emsi-edu.ma", txtFont));

            PdfPCell factureCell = new PdfPCell();
            factureCell.setBorder(Rectangle.NO_BORDER);
            Paragraph factureTitle = new Paragraph("FACTURE", titleFont);
            factureTitle.setAlignment(Element.ALIGN_RIGHT);
            factureCell.addElement(factureTitle);

            Paragraph factureNo = new Paragraph("N°: " + cmd.getCodeCmd(), hFont);
            factureNo.setAlignment(Element.ALIGN_RIGHT);
            factureCell.addElement(factureNo);

            Paragraph factureDate = new Paragraph("Date: " + DF.format(cmd.getDateCmd()), txtFont);
            factureDate.setAlignment(Element.ALIGN_RIGHT);
            factureCell.addElement(factureDate);

            header.addCell(companyCell);
            header.addCell(factureCell);
            document.add(header);

            document.add(new Paragraph(" "));
            document.add(new LineSeparator());

            // ===== CLIENT BLOCK + META =====
            PdfPTable meta = new PdfPTable(2);
            meta.setWidthPercentage(100);
            meta.setSpacingBefore(10);
            meta.setWidths(new float[]{60, 40});

            PdfPCell clientCell = new PdfPCell();
            clientCell.setBorder(Rectangle.BOX);
            clientCell.setBorderColor(new Color(220, 220, 220));
            clientCell.setPadding(10);
            clientCell.addElement(new Paragraph("Facturé à:", hFont));
            clientCell.addElement(new Paragraph(cmd.getClient(), txtFont));

            PdfPCell infoCell = new PdfPCell();
            infoCell.setBorder(Rectangle.BOX);
            infoCell.setBorderColor(new Color(220, 220, 220));
            infoCell.setPadding(10);
            infoCell.addElement(new Paragraph("Infos commande:", hFont));
            infoCell.addElement(new Paragraph("Code Commande: " + cmd.getCodeCmd(), txtFont));
            infoCell.addElement(new Paragraph("Code Produit: " + cmd.getCodePdt(), txtFont));
            infoCell.addElement(new Paragraph("Quantité: " + cmd.getQteCmd(), txtFont));

            meta.addCell(clientCell);
            meta.addCell(infoCell);
            document.add(meta);

            // ===== ITEMS TABLE =====
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setWidths(new float[]{50, 50});


            addHeaderCell(table, "Code produit", hFont);
            addHeaderCell(table, "Qté", hFont);

            // Only what you have now:
            addBodyCell(table, String.valueOf(cmd.getCodePdt()), txtFont);
            addBodyCell(table, String.valueOf(cmd.getQteCmd()), txtFont);

            document.add(table);



            // ===== FOOTER =====
            document.add(new Paragraph(" "));
            document.add(new LineSeparator());
            Paragraph thanks = new Paragraph("Merci pour votre confiance.", smallFont);
            thanks.setAlignment(Element.ALIGN_CENTER);
            document.add(thanks);

            Paragraph gen = new Paragraph("", smallFont);
            gen.setAlignment(Element.ALIGN_CENTER);
            document.add(gen);

            document.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("PDF generation failed: " + e.getMessage(), e);
        }
    }

    private void addHeaderCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(245, 245, 245));
        cell.setBorderColor(new Color(220, 220, 220));
        cell.setPadding(8);
        table.addCell(cell);
    }

    private void addBodyCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorderColor(new Color(220, 220, 220));
        cell.setPadding(8);
        table.addCell(cell);
    }

    private void addTotalsRow(PdfPTable totals, String label, String value, Font labelFont, Font valueFont) {
        PdfPCell l = new PdfPCell(new Phrase(label, labelFont));
        l.setBorderColor(new Color(220, 220, 220));
        l.setPadding(8);
        totals.addCell(l);

        PdfPCell v = new PdfPCell(new Phrase(value, valueFont));
        v.setBorderColor(new Color(220, 220, 220));
        v.setPadding(8);
        v.setHorizontalAlignment(Element.ALIGN_RIGHT);
        totals.addCell(v);
    }
}
