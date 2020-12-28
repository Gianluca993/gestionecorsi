<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.betacom.business.model.Docente"%>
<%@page import="it.betacom.business.model.Corso"%>
<%@page import="it.betacom.business.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@include file="logincheck.jsp"%>
<%
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	String stat = request.getParameter("stat");
	if(stat == null) {
		stat = "popcor";
	}
%>
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

	<div class="container my-3">

		<div class="col-md-5 ">
			<form method="get" action="#">
				<select class="form-control" name="stat" id="orderby"
					onchange="this.form.submit()">
					<option value="numcor" <%=stat.equals("popcor") ? "selected" : ""%>>Corso più popolare</option>
					<option value="numcor" <%=stat.equals("numcor") ? "selected" : ""%>>Numero totale dicorsisti</option>
					<option value="datin" <%=stat.equals("datin") ? "selected" : ""%>>Data di inizio dell'ultimo corso</option>
					<option value="durco" <%=stat.equals("durco") ? "selected" : ""%>>Durata media dei corsi</option>
					<option value="numcom" <%=stat.equals("numcom") ? "selected" : ""%>>Numero di commenti presenti</option>
					<option value="docen" <%=stat.equals("docen") ? "selected" : ""%>>Docente che può tenere più corsi</option>
					<option value="dispcor" <%=stat.equals("dispcor") ? "selected" : ""%>>Corsi con posti disponibili</option>
				</select>

			</form>
		</div>

	</div>
	<div class="container mt-4">

		<%
			if (stat.equals("popcor")) {
				Corso c = AdminFacade.getInstance().getCorsoPiuFreq();
		%>
		
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nome Corso</th>
						<th scope="col">Inizio Corso</th>
						<th scope="col">Fine Corso</th>
						<th scope="col">Costo Corso</th>
						<th scope="col">Commenti Corso</th>
						<th scope="col">Aula Corso</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><%=c.getNomeCorso()%></td>
						<td><%=formato.format(c.getDataInizio())%></td>
						<td><%=formato.format(c.getDataFine())%></td>
						<td><%=c.getCosto()%>&euro;</td>
						<td><%=c.getCommentiCorso()%></td>
						<td><%=c.getAulaCorso()%></td>
					</tr>
				</tbody>
			</table>

		</div>
		
		<%
			} else if (stat.equals("numcor")) {
				int numeroCors = AdminFacade.getInstance().getAllCorsisti().length;
		%>

		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Numero corsisti</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><%=numeroCors%></td>
					</tr>
				</tbody>
			</table>

		</div>

		<%
			} else if (stat.equals("datin")) {
				Corso c = AdminFacade.getInstance().getDataUltimoCorso();
		%>
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nome Corso</th>
						<th scope="col">Inizio Corso</th>
						<th scope="col">Fine Corso</th>
						<th scope="col">Costo Corso</th>
						<th scope="col">Commenti Corso</th>
						<th scope="col">Aula Corso</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><%=c.getNomeCorso()%></td>
						<td><%=formato.format(c.getDataInizio())%></td>
						<td><%=formato.format(c.getDataFine())%></td>
						<td><%=c.getCosto()%>&euro;</td>
						<td><%=c.getCommentiCorso()%></td>
						<td><%=c.getAulaCorso()%></td>
					</tr>
				</tbody>
			</table>

		</div>
		<%
			} else if (stat.equals("durco")) {
				double durata = AdminFacade.getInstance().getDurataMediaCorsi();
		%>
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Durata media corsi</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><%= durata %>h</td>
					</tr>
				</tbody>
			</table>

		</div>
		<%
			} else if (stat.equals("numcom")) {
		%>
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Numero commenti ai corsi</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td></td>
					</tr>
				</tbody>
			</table>

		</div>
		<%
			} else if (stat.equals("docen")) {
				Docente docente = AdminFacade.getInstance().getDocentePiuFormati();
				if(docente != null) {
		%>
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nome docente</th>
						<th scope="col">Cognome docente</th>
						<th scope="col">Corsi papabili</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><%= docente.getNomeDocente() %><td>
						<td><%= docente.getCognomeDocente() %></td>
						<td><%= docente.getCvDocente() %></td>
					</tr>
				</tbody>
			</table>

		</div>
		<%
				}
			} else {
				Corso[] corsiDisp = AdminFacade.getInstance().getCorsiDisponibili();
		%>
		<div class=col-md-12>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Nome Corso</th>
						<th scope="col">Inizio Corso</th>
						<th scope="col">Fine Corso</th>
						<th scope="col">Costo Corso</th>
						<th scope="col">Commenti Corso</th>
						<th scope="col">Aula Corso</th>
						<th scope="col">Numero Iscritti</th>
					</tr>
				</thead>
				<tbody>
					<% 
						for(Corso c : corsiDisp) {
							int numeroIscritti = AdminFacade.getInstance().getCorsoCorsistaByCorsoId(c.getIdCorso()).length;
					%>
					<tr>
						<td><%= c.getNomeCorso() %></td>
						<td><%=formato.format(c.getDataInizio())%></td>
						<td><%=formato.format(c.getDataFine())%></td>
						<td><%= c.getCosto() %>&euro;</td>
						<td><%= c.getCommentiCorso() %></td>
						<td><%= c.getAulaCorso() %></td>
						<td><%= numeroIscritti %>/12</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<%
			}
		%>
	</div>

	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>