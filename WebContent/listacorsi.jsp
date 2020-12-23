<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.betacom.business.AdminFacade" %>
<%@page import="it.betacom.business.model.Corso" %>
 <% Corso corsi[] = AdminFacade.getInstance().getAllCorsi(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:useBean id="carrello"
	class="it.betacom.business.controller.Login" scope="session" />
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<title>Dati Corsisti</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container mt-4 mb-2">
<div class=col-md-12>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id Corso</th>
      <th scope="col">Nome Corso</th>
      <th scope="col">Inizio Corso</th>
      <th scope="col">Fine Corso</th>
      <th scope="col">Costo Corso</th>
      <th scope="col">Commenti Corso</th>
      <th scope="col">Aula Corso</th>
      <th scope="col">Elimina</th>
    </tr>
  </thead>
  <tbody>
    <% for(Corso c : corsi){ %>
    <tr>
      <td><%= c.getIdCorso() %></td>
      <td><%= c.getNomeCorso() %></td>
      <td><%= c.getDataInizio() %></td>
      <td><%= c.getDataFine() %></td>
      <td><%= c.getCosto() %></td>
      <td><%= c.getCommentiCorso() %></td>
      <td><%= c.getAulaCorso() %></td>
      <td><button type="submit" class=" btn btn-danger"> Elimina Corso</button></td>
    </tr>
    <%} %>
  </tbody>
</table>

</div>
</div>




<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>