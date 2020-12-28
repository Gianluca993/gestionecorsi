<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.betacom.architecture.dao.DBAccess"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Connection"%>
<%@page import="it.betacom.business.AdminFacade"%>
<%@page import="it.betacom.business.model.Corsista"%>
<%@page import="it.betacom.business.model.CorsoCorsista"%>
<%@page import="it.betacom.business.model.Corso"%>
<% 
	String cognome = (String)session.getAttribute("cognome");
	if(cognome == null){
		response.sendRedirect("accessonegato.jsp");
	}
%>
<!DOCTYPE html>
<html>
	<head>
			<link rel="stylesheet" href="css/style.css">
		<%@include file="CDN.html" %>
		<meta name="viewport" content="width=device-width, initial-scale=1"></meta>

		<title>Modifica Corsista</title>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container d-flex justify-content-center">
		<div class="col-md-8 ">
			<div class="page-header">
				<h2>Modifica dati Corsista <span class="glyphicon glyphicon-cog"></span></h2>
			</div>
			<%
				Connection conn = DBAccess.getConnection();
				Corsista corsista = AdminFacade.getInstance().getCorsistaById(Long.parseLong(request.getParameter("id")));
				CorsoCorsista corsoCorsista = AdminFacade.getInstance().getLastCorsoCorsistaByCorsistaId(Long.parseLong(request.getParameter("id")));
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			%>
			<form action="/<%= application.getServletContextName() %>/modificacorsista" class="form-horizontal"
				method="post" id="FormCorsista">
				<input type="hidden" name="idCorsista" value="<%= corsista.getIdCorsista() %>">
				<div class="form-group">
					<label for="nome_corsista">Nome Corsista</label> <input type="text"
						class="form-control" id="Nomecorsista" name="nome"
						value= "<%= corsista.getNomeCorsista() %>" required>
				</div>
				<div class="form-group">
					<label for="cognomeCorsista">Cognome Corsista</label> <input
						type="text" class="form-control" id="cognomeCorsista"
						name="cognome" value= "<%= corsista.getCognomeCorsista() %>" required>
				</div>
				<div class="form-group">
					<label for="precformativi">Precedenti formativi</label> <input
						type="checkbox" class="form-control" name="prec"
						id="precformativi" value= "1" <%= corsista.isPrecFormativi() ? "checked" : "" %>>
				</div>
				
				
				<div class="form-group">
					<label for="corso_corsista">Corso:</label> 
					<select id="corso_corsista" name="corso" class="custom-select" multiple>
<%-- 						<option value="<%= corsoCorsista.getIdCorso() %>"> --%>
						<%
							Corso[] corsi = AdminFacade.getInstance().getAllCorsi();
							for(Corso c : corsi) {
								int iscritti = AdminFacade.getInstance().getCorsoCorsistaByCorsoId(c.getIdCorso()).length;
								if(iscritti < 12 && c.getDataFine().before(new Date())) {
									if(corsoCorsista != null) {
						%>
<%-- 						<%if (corsoCorsista.getIdCorso()) %> --%>
						<option value="<%= c.getIdCorso() %>" <%= c.getIdCorso()==corsoCorsista.getIdCorso()?"selected":"" %>><%= c.getNomeCorso() %></option>
						<%
									} else {
						
						%>
						<option value="<%= c.getIdCorso() %>"><%= c.getNomeCorso() %></option>
						<%
									}
								}
							}
						%>
					</select>
				</div>
				<button type="submit" class="btn btn-secondary">Modifica</button>
			</form>
			</div>
		</div>
		<footer class="footer"><%@include file="footer.html" %></footer>
	</body>
</html>
