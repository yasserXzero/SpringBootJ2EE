<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Commande - G_Vente</title>
    <link rel="stylesheet" href="<c:url value='/css/app.css'/>">
</head>
<body>

<header class="topbar">
    <div class="topbar__inner">
        <a class="brand" href="<c:url value='/accueil'/>">
            <div class="brand__logo">GV</div>
            <div class="brand__text">
                <div class="brand__name">G_Vente</div>
                <div class="brand__sub">Nouvelle commande</div>
            </div>
        </a>

        <div class="actions">
            <a class="btn" href="<c:url value='/accueil'/>">Accueil</a>
            <a class="btn btn--danger" href="<c:url value='/auth/logout'/>">Déconnexion</a>
        </div>
    </div>
</header>

<div class="container">
    <h1 class="page-title">Créer une commande</h1>
    <p class="page-subtitle">Saisissez les informations puis validez pour générer la facture.</p>

    <div class="card">

        <c:if test="${not empty error}">
            <div class="alert alert--danger">
                <strong>Erreur:</strong> ${error}
            </div>
        </c:if>

        <form class="form" method="post" action="<c:url value='/commande'/>">
            <!-- CSRF -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


            <div class="field">
                <label for="client">Client</label>
                <input class="input" id="client" type="text" name="client" maxlength="20" required />
            </div>

            <div class="field">
                <label for="codePdt">Produit</label>
                <select id="codePdt" name="codePdt" required>
                    <c:forEach items="${produits}" var="p">
                        <option value="${p.codePdt}">
                                ${p.codePdt} - ${p.nomPdt} (prix=${p.prixPdt}, stock=${p.qtePdt})
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="field">
                <label for="qteCmd">Quantité</label>
                <input class="input" id="qteCmd" type="number" name="qteCmd" min="1" required />
            </div>

            <div class="actions" style="justify-content:flex-start;">
                <button class="btn btn--primary" type="submit">Valider la commande</button>
                <a class="btn" href="<c:url value='/accueil'/>">Annuler</a>
            </div>
        </form>
    </div>

    <p class="small" style="margin-top:18px;">© <span id="year"></span> G_Vente</p>
</div>

<script defer src="<c:url value='/js/app.js'/>"></script>
</body>
</html>
