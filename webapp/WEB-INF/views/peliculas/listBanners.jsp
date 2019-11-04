<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<spring:url value="/peliculas/create" var="urlNew"></spring:url>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Peliculas</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>




<c:if test="${mensaje!=null }">
<div class="alert alert-success">
  ${mensaje}.
</div>
</c:if>



	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>

		<a href="${urlNew}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th></th>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>


				<c:forEach items="${peliculas}" var="pelicula">

					<tr>
						<td><img class="img-rounded"
							src="${urlPublic}/img/${pelicula.imagen}"
							alt="Generic placeholder image" width="75" height="100"></td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.genero}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.duracion}</td>
						<td><fmt:formatDate value="${pelicula.fechaEstreno}"
								pattern="dd-MM-yyyy" /></td>
						<td><c:choose>
								<c:when test="${pelicula.estatus=='Activa'}">
									<span class="label label-success">${pelicula.estatus}</span>
								</c:when>

								<c:otherwise>
									<span class="label label-danger">${pelicula.estatus}</span>
								</c:otherwise>

							</c:choose></td>
						<td><a href="#" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="#" class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>



				</c:forEach>


			</table>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
