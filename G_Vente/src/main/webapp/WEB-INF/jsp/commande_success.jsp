<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Commande validée</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        .box { border: 1px solid #ddd; padding: 16px; max-width: 520px; }
        .hidden { display:none; }
        button { padding: 10px 14px; cursor:pointer; }
    </style>
</head>
<body>

<div class="box">
    <h3>Commande ajoutée avec succès</h3>
    <p>Nous tentons d’ouvrir la facture dans un nouvel onglet…</p>

    <div id="blocked" class="hidden">
        <p style="color:#b00;">
            Votre navigateur a bloqué l’ouverture automatique du nouvel onglet.
        </p>
        <p>
            Cliquez ici pour ouvrir la facture :
            <a id="factureLink" href="#" target="_blank" rel="noopener">Ouvrir la facture</a>
        </p>
        <p>
            Ensuite vous pouvez revenir à l’accueil :
            <a href="<c:url value='/accueil'/>">Retour à l'accueil</a>
        </p>
    </div>

    <div id="ok" class="hidden">
        <p>Facture ouverte. Redirection vers l’accueil…</p>
    </div>
</div>

<script>
    (function () {
        const factureUrl = "<c:url value='/facture'/>?id=${id}";

        // Put the URL into the fallback link
        const link = document.getElementById("factureLink");
        link.href = factureUrl;

        // Attempt to open new tab
        const w = window.open(factureUrl, "_blank");


        if (!w) {
            document.getElementById("blocked").classList.remove("hidden");
            return;
        }

        document.getElementById("ok").classList.remove("hidden");
        setTimeout(function () {
            window.location.href = "<c:url value='/accueil'/>";
        }, 600);
    })();
</script>

<noscript>
    <p>
        JavaScript est désactivé.
        <a href="<c:url value='/facture'/>?id=${id}" target="_blank">Ouvrir la facture</a>
        |
        <a href="<c:url value='/accueil'/>">Retour à l'accueil</a>
    </p>
</noscript>

</body>
</html>
