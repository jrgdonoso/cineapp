<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>CineSite | Bienvenido</title>


<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

<form name='form' action='${urlRoot}login' method='POST'>

<!-- Error al intentar ingresar -->
<c:if test="${param.error != null}">
<img src="${urlPublic}/img/error.png" width="48" height="48" class="center">
<h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
</c:if>



Usuario:<br>
<input type='text' name='username' ><br>
Password:<br>
<input type='password' name='password'><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<!--  Para evitar ataque cross-page -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<input name="submit" type="submit" value="Ingresar" >
</form>
</body>
</html>
