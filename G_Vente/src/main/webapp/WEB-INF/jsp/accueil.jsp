<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Bienvenue ${user}</h2>

<a href="/produits?token=${token}">
    <button>Voir les produits</button>
</a>

<br/><br/>

<a href="/commande?token=${token}">
    <button>Créer une commande</button>
</a>
