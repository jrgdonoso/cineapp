<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- TagLib seguridad -->
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>



<spring:url value="/" var="urlRoot1" />

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${urlRoot1}admin/index">My CineSite</a>
		</div>




<!-- Usuario no registrado -->
		<div id="navbar" class="navbar-collapse collapse">
			<sec:authorize access="isAnonymous()">
				<ul class="nav navbar-nav">

					<li><a href="${urlRoot1}formLogin">Login</a></li>
				</ul>
			</sec:authorize>
			
			<!-- Usuario EDITOR -->
			<sec:authorize access="hasAnyAuthority('EDITOR')">
			<ul class="nav navbar-nav">
					<li><a href="${urlRoot1}peliculas/index">Peliculas</a></li>
					<li><a href="${urlRoot1}admin/logout">Salir</a></li>
				</ul>
			</sec:authorize>
			
			
			<!-- Usuario GERENTE -->
			<sec:authorize access="hasAnyAuthority('GERENTE')">
			<ul class="nav navbar-nav">
					<li><a href="${urlRoot1}peliculas/index">Peliculas</a></li>
					<li><a href="${urlRoot1}banners/index">Banners</a></li>
					<li><a href="${urlRoot1}admin/logout">Salir</a></li>
				</ul>
			</sec:authorize>
			
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>