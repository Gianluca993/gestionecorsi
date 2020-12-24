<%@page import="it.betacom.business.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.betacom.business.model.Corso"%>
<%@page import="it.betacom.business.model.CorsoCorsista"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="it.betacom.business.AdminFacade" %>
<%@page import="it.betacom.business.model.Corsista" %>
 <%
 	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
 	Corsista corsisti[] = AdminFacade.getInstance().getAllCorsisti(); 
 %>
 <%@include file="logincheck.jsp"%>
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


<div class="container mt-5 corsistilist d-flex justify-content-center" >
<div class=col-md-12>
<table class="table table-hover table-striped text-light">
  <thead>
    <tr>
      <th scope="col">Id corsista</th>
      <th scope="col">Nome corsista</th>
      <th scope="col">Cognome corsista</th>
      <th scope="col">Ultimo corso seguito</th>
      <th scope="col">Modifica</th>
      <th scope="col">Elimina</th>
    </tr>
  </thead>
  <tbody>
  <% 
  for(Corsista c : corsisti){ 
  	CorsoCorsista lastCorsoCorsista = AdminFacade.getInstance().getLastCorsoCorsistaByCorsistaId(c.getIdCorsista());
  	String last = "";
  	Corso lastCorso = null;
  	if(lastCorsoCorsista != null) {
  		lastCorso = AdminFacade.getInstance().getCorsoById(lastCorsoCorsista.getIdCorso());
  		last = lastCorso.getNomeCorso();
  	}
  	
  %>
    <tr data-toggle="modal" data-target="#modal<%= c.getIdCorsista()  %>">
      <td><%= c.getIdCorsista() %></td>
      <td><%= c.getNomeCorsista() %></td>
      <td> <%= c.getCognomeCorsista() %></td>
      <td> <%= last %></td>
      <td><a href="modificacorsista.jsp?id=<%=c.getIdCorsista() %>"><button type="submit" class="btn btn-secondary">Modifica</button></a></td>
      <td>
	      <form action="/<%=application.getServletContextName()%>/eliminacorsista" method="post">
	      	<input type="hidden" name="id" value="<%= c.getIdCorsista() %>">
	        <button type="submit" class="btn btn-primary">Elimina</button>
	      </form>
     </td>
     <td>
     <%
     	Docente docente = AdminFacade.getInstance().getDocenteById(lastCorso.getIdDocente());
     %>
     
		     	<!-- Modal -->
		<div class="modal fade" id="modal<%= c.getIdCorsista() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header text-center" style="color: white; background-color:#1F2041;">
		        <h5 class="modal-title w-100" id="exampleModalLongTitle"><%= lastCorso.getNomeCorso()  %></h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body"  style="background-color:#3C3D7C;">
		        <table class="table">
		          <tr>
		          	<td>Data inizio corso:</td>
		          	<td><%= formato.format(lastCorso.getDataInizio()) %></td>
		          </tr>
		          <tr>
		          	<td>Data fine corso:</td>
		          	<td><%= formato.format(lastCorso.getDataFine()) %></td>
		          </tr>
		          <tr>
		          	<td>Costo:</td>
		          	<td><%= lastCorso.getCosto() %>&euro;</td>
		          </tr>
		          <tr>
		          	<td>Aula:</td>
		          	<td><%= lastCorso.getAulaCorso() %></td>
		          </tr>
		          <tr>
		          	<td>Docente:</td>
		          	<td><%= docente.getNomeDocente() %>&nbsp;<%= docente.getCognomeDocente()  %></td>
		          </tr>
		        </table>
		      </div>
		      <div class="modal-footer" style="background-color:#1F2041;">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Chiudi</button>
		      </div>
		    </div>
		  </div>
		</div>
     </td>
    </tr>
    
    <%} %>
  </tbody>
</table>

</div>
</div>


<div class="container mt-4 d-flex justify-content-center">
<a href="inseriscicorsista.jsp" style="margin-right:5px;"><button type="submit" class="btn btn-primary">Inserisci corsista</button></a>
<a href="visualizzastatistiche.jsp" style="margin-right:5px;"><button type="submit" class="btn btn-primary">Visualizza Statistiche</button></a>
<a href="listacorsi.jsp"><button class="btn btn-primary">Elimina Corso</button></a>
</div>




<footer class="footer"><%@include file="footer.html" %></footer>
</body>
</html>