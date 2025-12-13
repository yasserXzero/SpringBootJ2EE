<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Commande validée - G_Vente</title>
    <link rel="stylesheet" href="<c:url value='/css/app.css'/>">
</head>
<body>

<header class="topbar">
    <div class="topbar__inner">
        <a class="brand" href="<c:url value='/accueil'/>">
            <div class="brand__logo">GV</div>
            <div class="brand__text">
                <div class="brand__name">G_Vente</div>
                <div class="brand__sub">Commande</div>
            </div>
        </a>

        <div class="actions">
            <a class="btn" href="<c:url value='/accueil'/>">Accueil</a>
            <a class="btn btn--danger" href="<c:url value='/auth/logout'/>">Déconnexion</a>
        </div>
    </div>
</header>

<div class="container">
    <h1 class="page-title">Commande ajoutée avec succès</h1>
    <p class="page-subtitle">Nous allons ouvrir la facture et vous rediriger vers l’accueil.</p>

    <div class="card" id="successCard">

        <div class="alert alert--success" id="autoOpenMsg">
            <strong>Info:</strong> Tentative d’ouverture automatique de la facture…
        </div>

        <div class="alert alert--danger" id="blockedMsg" style="display:none;">
            <strong>Action requise:</strong> Votre navigateur a bloqué l’ouverture automatique.
            Cliquez sur “Ouvrir la facture”.
        </div>

        <div class="actions" style="justify-content:flex-start;">
            <a class="btn btn--primary" id="openFactureBtn" href="#" target="_blank" rel="noopener">
                Ouvrir la facture
            </a>

            <a class="btn" id="backHomeBtn" href="<c:url value='/accueil'/>">
                Retour à l’accueil
            </a>
        </div>

        <p class="small" style="margin-top:10px;">
            Facture ID: <strong>${id}</strong>
        </p>

    </div>

    <p class="small" style="margin-top:18px;">© <span id="year"></span> G_Vente</p>
</div>

<script defer src="<c:url value='/js/app.js'/>"></script>

<script>
    (function () {
        const factureUrl = "<c:url value='/facture'/>?id=${id}";

        const openBtn = document.getElementById("openFactureBtn");
        const blockedMsg = document.getElementById("blockedMsg");
        const autoOpenMsg = document.getElementById("autoOpenMsg");

        openBtn.href = factureUrl;

        // Try opening automatically
        const w = window.open(factureUrl, "_blank");

        if (!w) {
            // blocked => show warning, let user click
            blockedMsg.style.display = "block";
            autoOpenMsg.style.display = "none";
            return;
        }

        // Opened => redirect after a short delay
        setTimeout(function () {
            window.location.href = "<c:url value='/accueil'/>";
        }, 700);

    })();
</script>

<noscript>
    <div class="container">
        <div class="card">
            <div class="alert alert--danger">
                JavaScript est désactivé. Utilisez les liens ci-dessous.
            </div>
            <div class="actions" style="justify-content:flex-start;">
                <a class="btn btn--primary" href="<c:url value='/facture'/>?id=${id}" target="_blank">Ouvrir la facture</a>
                <a class="btn" href="<c:url value='/accueil'/>">Retour à l’accueil</a>
            </div>
        </div>
    </div>
</noscript>

</body>
</html>
