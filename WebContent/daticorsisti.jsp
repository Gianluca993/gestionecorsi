<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.betacom.business.AdminFacade" %>
<%@page import="it.betacom.business.model.Corsista" %>
 <% Corsista corsisti[] = AdminFacade.getInstance().getAllCorsisti(); %>
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


<div class="container mt-4 corsistilist" >
<div class=col-md-12>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id Corsista</th>
      <th scope="col">Nome Corsista</th>
      <th scope="col">Cognome Corsista</th>
      <th scope="col">Modifica</th>
      <th scope="col">Elimina</th>
    </tr>
  </thead>
  <tbody>
  <% for(Corsista c : corsisti){ %>
    <tr>
      <td><%= c.getIdCorsista() %></td>
      <td><%= c.getNomeCorsista() %></td>
      <td> <%= c.getCognomeCorsista() %></td>
      <td><a href="modificacorsista.jsp?id=<%=c.getIdCorsista() %>"><button type="submit" class="btn btn-warning">Modifica</button></a></td>
      <td><a href="eliminacorsista.jsp"><button type="submit" class="btn btn-danger">Elimina</button></a></td>
    </tr>
    <%} %>
  </tbody>
</table>

</div>
</div>


<div class="container mt-2">
<a href="inseriscicorsista.jsp"><button type="submit" class="btn btn-info">Inserisci corsista</button></a>
<a href="visualizzastatistiche.jsp"><button type="submit" class="btn btn-success">Visualizza Statistiche</button></a>
<a href="eliminacorso.jsp"><button type="submit" class="btn btn-danger">Elimina Corso</button></a>
</div>




<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>