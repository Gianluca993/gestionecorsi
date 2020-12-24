<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<%@include file="CDN.html" %>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Accesso Negato</title>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<div class="page-header">
				<h3>Non puoi accedere a questa pagina</h3>
			</div>
			<div class="panel panel-danger">
				<div class="page-heading">
					<p>Risorsa non disponibile</p>
				</div>
				<div class="panel-body">
					<p>Per accedere alla pagina riciesta:</p>
					<p>Devi essere un admin. Se lo sei, effettua il login - <a href="index.jsp">Login</a></p>
				</div>
			</div>
		</div>
		<footer class="footer"><%@include file="footer.html" %></footer>
	</body>
</html>