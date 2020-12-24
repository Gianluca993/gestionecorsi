<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	if(session.getAttribute("cognome") != null) {
    		response.sendRedirect("daticorsisti.jsp");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<title>Home</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container d-flex justify-content-center ">

<div class="col-md-4 mt-3">
<form action="/<%=application.getServletContextName()%>/login"
			class="form-horizontal" method="post" id="adminForm">
  <div class="form-group">
    <label for="id_admin" class="lognom">Id Admin</label>
    <input type="text" class="form-control" id="adaccess" name="id" placeholder="Enter Id" required>
  </div>
 
 
   <div class="form-group">
    <label for="cognome_admin" class="lognom">Cognome Admin</label>
    <input type="text" class="form-control" id="cogadmin" name="cognome" placeholder="Enter Cognome" required>
  </div>
 
 <button type="submit" class="btn btn-primary">Entra</button>
</form>

</div>



</div>



<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>