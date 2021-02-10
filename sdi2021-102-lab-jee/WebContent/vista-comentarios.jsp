<%@ page language="java"	contentType="text/html;	charset=utf-8"
				pageEncoding="utf-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"	%>
<!DOCTYPE html	PUBLIC "-//W3C//DTD	HTML	4.01	Transitional//EN"	
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
			<title>JSP</title>
			<meta charset="utf-8"/>
			<meta name="viewport"	content="width=device-width,	initial-scale=1"/>
			<link rel="stylesheet"	
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>		
		<!-- Contenido -->
		<div class="container"	id="contenedor-principal">
			<h2>Comentarios</h2>
				<div><a href="formComentario.jsp" class="btn btn-default" >	Nuevo Comentario </a></div>
				<div class="row	">
					<c:forEach	var="comentario"	begin="0"	items="${comentarios}">
					<div class="col-xs-12	col-sm-6	col-md-4	col-lg-3">
						<div>
							<div><c:out	value="${comentario.autor}"/></div>
								<c:out	value="${comentario.texto}"/>€
						</div>
					</div>
					</c:forEach>
				</div>
				<a	href=".\index.jsp">Volver</a>
		</div>
	</body>
</html>