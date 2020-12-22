<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<%@include file="CDN.html"%>
<title>Inserisci corsista</title>
</head>
<body>
<jsp:include page="nav.jsp" />


<div class="container-fluid align-context-center">
<h1>Inserisci corsista</h1>
<div class=col-md-4>
<form action="/<%=application.getServletContextName()%>/create"
			class="form-horizontal" method="post" id="corsistaForm">
  <div class="form-group">
    <label for="nome_corsista">Nome Corsista</label>
    <input type="text" class="form-control" id="Nomecorsista" placeholder="Nome.." required>
  </div>
 
 
   <div class="form-group">
    <label for="cognomeCorsista">Cognome Corsista</label>
    <input type="text" class="form-control" id="cognomeCorsista" placeholder="Cognome" required>
  </div>
 
 
 <div class="form-group">
    <label for="precformativi">Precedenti formativi</label>
    <input type="checkbox" class="form-control" id="precformativi"required>
  </div>
  <div class="form-group">
    <label for="corso_corsista">Precedenti formativi</label>
    <input type="checkbox" class="form-control" id="corso_corsista"required>
  </div>
 
 
 
 <button type="submit" class="btn btn-primary">Aggiungi</button>
</form>

</div>



</div>



<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>