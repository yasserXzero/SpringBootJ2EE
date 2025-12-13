    package com.example.g_commercial.entity;


    import jakarta.persistence.*;

    @Entity
    @Table(name = "produits_prix")
    public class Produits_Prix {

        @Id
        @Column(name = "code_pdt")
        @GeneratedValue( strategy = GenerationType.IDENTITY)
        private Long codePdt;

        @Column(name = "nom_pdt", length = 20)
        private String nomPdt;

        @Column(name = "desc_pdt", length = 200)
        private String descPdt;

        @Column(name = "prix_pdt")
        private Long prixPdt;

        public Produits_Prix(String nomPdt, String descPdt, Long prixPdt) {
            this.nomPdt = nomPdt;
            this.descPdt = descPdt;
            this.prixPdt = prixPdt;
        }

        public Produits_Prix(Long codePdt, String nomPdt, String descPdt, Long prixPdt) {
            this.codePdt = codePdt;
            this.nomPdt = nomPdt;
            this.descPdt = descPdt;
            this.prixPdt = prixPdt;
        }

        public Produits_Prix() {
        }

        public Long getCodePdt() {
            return codePdt;
        }

        public void setCodePdt(Long codePdt) {
            this.codePdt = codePdt;
        }

        public String getNomPdt() {
            return nomPdt;
        }

        public void setNomPdt(String nomPdt) {
            this.nomPdt = nomPdt;
        }

        public String getDescPdt() {
            return descPdt;
        }

        public void setDescPdt(String descPdt) {
            this.descPdt = descPdt;
        }

        public Long getPrixPdt() {
            return prixPdt;
        }

        public void setPrixPdt(Long prixPdt) {
            this.prixPdt = prixPdt;
        }
    }
