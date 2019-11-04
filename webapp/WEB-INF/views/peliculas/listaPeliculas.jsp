<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<spring:url value="/resources" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<spring:url value="/peliculas/save" var="urlForm"></spring:url>
<spring:url value="/peliculas/edit" var="urlEdit"></spring:url>
<spring:url value="/peliculas/delete" var="urlDelete"></spring:url>


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

	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>

		<a href="${urlRoot}/peliculas/create" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				
				<c:forEach var="pelicula" items="${peliculas.content}">
					<tr>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.genero}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.duracion}</td>
						<td></td>
						<td></td>
						<td>
							<a href="${urlEdit}/${pelicula.id}" class="btn btn-success btn-sm" role="button"
							title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							
							<a href="${urlDelete}/${pelicula.id}"  onclick=" return confirm('Seguro que desea eliminar')" class="btn btn-danger btn-sm" role="button"
							title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>



				</c:forEach>
			</table>
			
			
			<nav aria-label="">
<ul class="pager">
<li><a href="${urlRoot}peliculas/index?page=${peliculas.number - 1 }">Anterior</a></li>
<li><a href="${urlRoot}peliculas/index?page=${peliculas.number + 1 }">Siguiente</a></li>
</ul>
</nav>


			
			
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a>
				&middot; <a href="#">Terms</a>
			</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
