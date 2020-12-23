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
<title>Dati Corsisti</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container mt-4">
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
   
    <tr>
      <td scope="row"></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td><button type="submit" class=" btn btn-danger"> Elimina Corso</button></td>
    </tr>
  </tbody>
</table>

</div>
</div>


<div class="container mt-5 ">
<a href="inseriscicorsista.jsp"><button type="submit" class="btn btn-info">Inserisci corsista</button></a>
<a href="visualizzastatistiche.jsp"><button type="submit" class="btn btn-success">Visualizza Statistiche</button></a>
<a href="eliminacorso.jsp"><button type="submit" class="btn btn-danger">Elimina Corso</button></a>
</div>




<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>