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
	} else {
%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="CDN.html" %>
		<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
		<link rel="stylesheet" href="css/style.css">
		<title>Modifica Corsista</title>
	</head>
	<body>
		<jsp:include page="nav.jsp"/>
		<div class="container">
			<div class="page-header">
				<h2>Modifica dati <span class="glyphicon glyphicon-cog"></span></h2>
			</div>
			<%
				Connection conn = DBAccess.getConnection();
				Corsista corsista = AdminFacade.getInstance().getCorsistaById(Long.parseLong(request.getParameter("idCorsista")));
				CorsoCorsista corsiCorsisti[] = AdminFacade.getInstance().getCorsoCorsistaByCorsistaId(Long.parseLong(request.getParameter("idCorsista")));
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				CorsoCorsista corsoCorsista = null;
				for(CorsoCorsista c : corsiCorsisti){
					if(c.getIdCorso()==)
				}
			%>
			<form action="/<%= application.getServletContextName() %>/modificacorsista" class="form-horizontal"
				method="post" id="FormCorsista">
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
						id="precformativi" value= "<%= corsista.isPrecFormativi() %>" >
				</div>
				<div class="form-group">
					<label for="corso_corsista">Corso:</label> 
					<select id="corso_corsista" name="corso" class="custom-select" multiple>
<%-- 						<option value="<%= corsoCorsista.getIdCorso() %>"> --%>
						<%
							Corso[] corsi = AdminFacade.getInstance().getAllCorsi();
							for(Corso c : corsi) {
						%>
<%-- 						<%if (corsoCorsista.getIdCorso()) %> --%>
						<option value="<%= c.getIdCorso() %>" <%= c.getIdCorso()==corsoCorsista.getIdCorso()?"selected":"" %>><%= c.getNomeCorso() %></option>
						<%
							}
						%>
					</select>
				</div>
				<button type="submit" class="btn btn-warning">Modifica</button>
			</form>
		</div>
		<footer class="footer"><%@include file="footer.html" %></footer>
	</body>
</html>
<%
	}
%>