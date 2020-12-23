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

<div class="container my-3">

<div class="col-md-5">
<form method="get" action="#">
<select class="form-control" name ="stat" id="orderby" onchange="this.form.submit()">
      <option value="numcor">Numero corsisti</option>
      <option value="datin">Data Inizio</option>
      <option value="durco">Durata Corso</option>
      <option value="numcom">Numero Commenti</option>
      <option value="docen">Docente</option>
      <option value="dispcor">Corsi disponibili</option>
    </select>

</form>
</div>


</div>
<div class="container mt-4">
<div class=col-md-12>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Numero corsisti</th>
      <th scope="col">Data Inizio</th>
      <th scope="col">Durata Corso</th>
      <th scope="col">Numero commenti</th>
      <th scope="col">Più corsi per Docente</th>
      <th scope="col">Corsi disponibili</th>
      <th scope="col">Corsisti </th>
    </tr>
  </thead>
  <tbody>
   
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </tbody>
</table>

</div>
</div>







<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>