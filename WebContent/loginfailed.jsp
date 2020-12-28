<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="Refresh" content="5;url=index.jsp">
		<link rel="stylesheet" href="css/style.css">
		<%@include file="CDN.html" %>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login fallito</title>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<div class="page-header">
				<h3>Login fallito</h3>
			</div>
			<div class="panel panel-danger">
				<div class="page-heading">
					<h5 style="color:white;">Hai superato i numero di tentativi</h5>
				</div>
				<div class="panel-body">
					<p style="color:white;">Verrai reindirizzato automaticamente alla pagina per tentare nuovamente il login</p>
				</div>
			</div>
		</div>
		<footer class="footer"><%@include file="footer.html" %></footer>
	</body>
</html>