<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
	<head>
	    <title>Page Login</title>
	</head>
	<body>
		<h2>Connexion</h2>
        <form action="/auth" method="post">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            Login: <input type="text" name="login"/><br/>
            Mot de passe: <input type="password" name="password"/><br/>
            <input type="submit" value="Se connecter"/>
        </form>

		
		<c:if test="${not empty error}">
		    <p style="color:red">${error}</p>
		</c:if>
	</body>
</html>