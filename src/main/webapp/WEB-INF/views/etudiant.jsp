<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: banksy
  Date: 1/3/2020
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
<p>
    <h3>Bonjour <c:out value="${personne.nom} ${personne.prenom}"/></h3>
</p>

</body>
</html>
