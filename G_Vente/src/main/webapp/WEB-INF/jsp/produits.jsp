<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Produits - G_Vente</title>
    <link rel="stylesheet" href="<c:url value='/css/app.css'/>">
</head>
<body>

<header class="topbar">
    <div class="topbar__inner">
        <a class="brand" href="<c:url value='/accueil'/>">
            <div class="brand__logo">GV</div>
            <div class="brand__text">
                <div class="brand__name">G_Vente</div>
                <div class="brand__sub">Produits</div>
            </div>
        </a>

        <div class="actions">
            <a class="btn" href="<c:url value='/accueil'/>">Accueil</a>
            <a class="btn btn--danger" href="<c:url value='/auth/logout'/>">Déconnexion</a>
        </div>
    </div>
</header>

<div class="container">
    <h1 class="page-title">Produits en stock</h1>
    <p class="page-subtitle">Liste synchronisée depuis gestion_stock + gestion_commercial.</p>

    <div class="card">
        <div class="toolbar">
            <div class="search">
                <input class="input" id="tableSearch" type="text" placeholder="Rechercher (code, nom, prix, quantité)..." />
            </div>
            <span class="small">Total lignes: <c:out value="${fn:length(produits)}"/></span>
        </div>

        <div class="table-wrap">
            <table id="produitsTable">
                <thead>
                <tr>
                    <th>Code Produit</th>
                    <th>Nom Produit</th>
                    <th>Prix</th>
                    <th>Quantité</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${produits}" var="p">
                    <tr>
                        <td>${p.codePdt}</td>
                        <td>${p.nomPdt}</td>
                        <td>${p.prixPdt}</td>
                        <td>${p.qtePdt}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <p class="small" style="margin-top:18px;">© <span id="year"></span> G_Vente</p>
</div>

<script defer src="<c:url value='/js/app.js'/>"></script>
</body>
</html>
