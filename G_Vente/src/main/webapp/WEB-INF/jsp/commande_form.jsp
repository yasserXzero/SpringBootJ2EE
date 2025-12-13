<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Créer une commande</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form method="post" action="/commande">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <label>Code Commande:</label>
    <input type="number" name="codeCmd" required /><br/><br/>

    <label>Client:</label>
    <input type="text" name="client" maxlength="20" required /><br/><br/>

    <label>Produit:</label>
    <select name="codePdt" required>
        <c:forEach items="${produits}" var="p">
            <option value="${p.codePdt}">
                    ${p.codePdt} - ${p.nomPdt} (prix=${p.prixPdt}, stock=${p.qtePdt})
            </option>
        </c:forEach>
    </select><br/><br/>

    <label>Quantité:</label>
    <input type="number" name="qteCmd" min="1" required /><br/><br/>

    <button type="submit">Valider la commande</button>
</form>
