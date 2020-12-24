<%@page import="it.betacom.business.model.Corso"%>
<%@page import="it.betacom.business.AdminFacade"%>
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


	<div class="container-fluid d-flex justify-content-center">
		
		<div class=col-md-4>
		<h1 class="mx-5 mt-3">Inserisci corsista</h1>
			<form
				action="/<%=application.getServletContextName()%>/aggiungicorsista"
				class="form-horizontal" method="post" id="corsistaForm">
				<div class="form-group">
					<label for="nome_corsista">Nome Corsista</label> <input type="text"
						class="form-control" id="Nomecorsista" name="nome"
						placeholder="Nome.." required>
				</div>


				<div class="form-group">
					<label for="cognomeCorsista">Cognome Corsista</label> <input
						type="text" class="form-control" id="cognomeCorsista"
						name="cognome" placeholder="Cognome" required>
				</div>


				<div class="form-group">
					<label for="precformativi">Precedenti formativi</label> <input
						type="checkbox" class="form-control" name="prec"
						id="precformativi" value="1">
				</div>

				<div class="form-group">
					<label for="corso_corsista">Corso:</label> 
					<select id="corso_corsista" name="corso" class="custom-select" multiple>
						<%
							Corso[] corsi = AdminFacade.getInstance().getAllCorsi();
							for(Corso c : corsi) {
						%>
						<option value="<%= c.getIdCorso() %>"><%= c.getNomeCorso() %></option>
						<%
							}
						%>
					</select>
				</div>



				<button type="submit" class="btn btn-primary">Aggiungi</button>
			</form>

		</div>



	</div>



	<footer class="footer"><%@include file="footer.html"%></footer>
</body>
</html>