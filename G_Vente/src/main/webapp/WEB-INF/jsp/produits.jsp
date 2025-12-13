
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Produits en Stock</title>
</head>
<body>

<h2>Liste des Produits en Stock</h2>

<table border="1">
    <tr>
        <th>Code Produit</th>
        <th>Nom Produit</th>
        <th>Prix</th>
        <th>Quantité</th>
    </tr>

    <c:forEach items="${produits}" var="p">
        <tr>
            <td>${p.codePdt}</td>
            <td>${p.nomPdt}</td>
            <td>${p.prixPdt}</td>
            <td>${p.qtePdt}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
