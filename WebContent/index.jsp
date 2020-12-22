<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:useBean id="carrello"
	class="it.betacom.business.controller.Login" scope="session" />
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<title>Home</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container-fluid align-context-center">
<div class=col-md-4>
<form action="/<%=application.getServletContextName()%>/login"
			class="form-horizontal" method="post" id="adminForm">
  <div class="form-group">
    <label for="id_admin">Id Admin</label>
    <input type="text" class="form-control" id="adaccess" placeholder="Enter Id" required>
  </div>
 
 
   <div class="form-group">
    <label for="cognome_admin">Cognome Admin</label>
    <input type="text" class="form-control" id="cogadmin" placeholder="Enter Cognome" required>
  </div>
 
  <a href="#"><button type="submit" class="btn btn-primary">Entra</button></a>
</form>

</div>



</div>



<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>