<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Accueil - G_Vente</title>
    <link rel="stylesheet" href="<c:url value='/css/app.css'/>">
</head>
<body>

<header class="topbar">
    <div class="topbar__inner">
        <a class="brand" href="<c:url value='/accueil'/>">
            <div class="brand__logo">GV</div>
            <div class="brand__text">
                <div class="brand__name">G_Vente</div>
                <div class="brand__sub">Gestion de vente</div>
            </div>
        </a>

        <div class="actions">
            <a class="btn btn--danger" href="<c:url value='/auth/logout'/>">Déconnexion</a>
        </div>
    </div>
</header>

<div class="container">
    <h1 class="page-title">Bienvenue ${user}</h1>
    <p class="page-subtitle">Choisissez une action pour continuer.</p>

    <div class="grid grid--2">
        <div class="kpi">
            <h3 class="kpi__title">Produits en stock</h3>
            <p class="kpi__desc">Consultez la liste des produits et leurs quantités disponibles.</p>
            <a class="btn btn--primary" href="<c:url value='/produits'/>">Voir les produits</a>
        </div>

        <div class="kpi">
            <h3 class="kpi__title">Créer une commande</h3>
            <p class="kpi__desc">Créer une commande et générer automatiquement la facture PDF.</p>
            <a class="btn btn--primary" href="<c:url value='/commande'/>">Nouvelle commande</a>
        </div>
    </div>

    <p class="small" style="margin-top:18px;">© <span id="year"></span> G_Vente</p>
</div>

<script defer src="<c:url value='/js/app.js'/>"></script>
</body>
</html>
