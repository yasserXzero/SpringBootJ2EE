<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Connexion</title>

    <link rel="stylesheet" href="<c:url value='/css/login.css'/>">
</head>
<body>

<main class="wrap">
    <section class="panel" id="loginPanel">

        <!-- Left branding -->
        <aside class="panel__left">
            <div class="brand">
                <div class="brand__logo">GV</div>
                <div class="brand__name">G_Vente</div>
                <div class="brand__tag">Gestion de vente • Accès sécurisé</div>
            </div>

            <div class="brand__bullets">
                <div class="bullet">
                    <div class="bullet__dot"></div>
                    <div class="bullet__text">Interface simple et rapide</div>
                </div>
                <div class="bullet">
                    <div class="bullet__dot"></div>
                    <div class="bullet__text">Facture PDF après commande</div>
                </div>
                <div class="bullet">
                    <div class="bullet__dot"></div>
                    <div class="bullet__text">Accès protégé</div>
                </div>
            </div>

            <div class="brand__footer">
                <span>© <span id="year"></span> G_Vente</span>
            </div>
        </aside>

        <!-- Right form -->
        <div class="panel__right">
            <h1 class="title">Connexion</h1>
            <p class="subtitle">Entrez vos identifiants pour continuer.</p>

            <c:if test="${not empty error}">
                <div class="alert" id="errorBox">
                    <strong>Erreur:</strong> <span>${error}</span>
                </div>
            </c:if>

            <form class="form" action="<c:url value='/auth'/>" method="post" autocomplete="on">
                <!-- CSRF -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                <div class="field">
                    <label class="field__label" for="login">Login</label>
                    <input class="field__input" id="login" name="login" type="text" required maxlength="20"
                           autocomplete="username" />
                </div>

                <div class="field">
                    <label class="field__label" for="password">Mot de passe</label>
                    <div class="field__row">
                        <input class="field__input" id="password" name="password" type="password" required
                               autocomplete="current-password" />
                        <button type="button" class="toggle" id="togglePwd">Afficher</button>
                    </div>
                </div>

                <button class="btn" type="submit" id="submitBtn">Se connecter</button>
            </form>

            <p class="help">Conseil: si l’ouverture auto de la facture est bloquée, cliquez sur le lien proposé.</p>
        </div>

    </section>
</main>

<script defer src="<c:url value='/js/login.js'/>"></script>
</body>
</html>
