<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<title>Dati Corsisti</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container mt-4">
<div class=col-md-5>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id Corsista</th>
      <th scope="col">Nome Corsista</th>
      <th scope="col">Cognome Corsista</th>
      <th scope="col">Corso Attuale</th>
    </tr>
  </thead>
  <tbody>
   
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>Meccatronica</td>
    </tr>
  </tbody>
</table>

</div>



</div>



<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>