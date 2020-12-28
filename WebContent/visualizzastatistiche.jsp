<%@page import="java.util.Date"%>
<%@page import="it.betacom.business.model.CorsoCorsista"%>
<%@page import="it.betacom.business.model.Corsista"%>
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
if (stat == null) {
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
					<option value="numcor" <%=stat.equals("popcor") ? "selected" : ""%>>Corso
						più popolare</option>
					<option value="numcor" <%=stat.equals("numcor") ? "selected" : ""%>>Numero
						totale dicorsisti</option>
					<option value="datin" <%=stat.equals("datin") ? "selected" : ""%>>Data
						di inizio dell'ultimo corso</option>
					<option value="durco" <%=stat.equals("durco") ? "selected" : ""%>>Durata
						media dei corsi</option>
					<option value="numcom" <%=stat.equals("numcom") ? "selected" : ""%>>Numero
						di commenti presenti</option>
					<option value="listcors"
						<%=stat.equals("listcors") ? "selected" : ""%>>Lista
						corsisti</option>
					<option value="docen" <%=stat.equals("docen") ? "selected" : ""%>>Docente
						che può tenere più corsi</option>
					<option value="dispcor"
						<%=stat.equals("dispcor") ? "selected" : ""%>>Corsi con
						posti disponibili</option>
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
		int durata = AdminFacade.getInstance().getDurataMediaCorsi();
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
						<td><%=durata%> Giorni</td>
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
			} else if (stat.equals("listcors")) {
			 	Corsista corsisti[] = AdminFacade.getInstance().getAllCorsisti(); 
		%>

		<div class=col-md-12>
			<table class="table table-hover table-striped text-light">
				<thead>
					<tr>
						<th scope="col">Id corsista</th>
						<th scope="col">Nome corsista</th>
						<th scope="col">Cognome corsista</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Corsista c : corsisti) {
						CorsoCorsista[] corsiCorsisti = AdminFacade.getInstance().getCorsoCorsistaByCorsistaId(c.getIdCorsista());
						if (corsiCorsisti != null) {
					%>
					<tr data-toggle="modal"
						data-target="#modal<%=c.getIdCorsista()%>">
						<td><%=c.getIdCorsista()%></td>
						<td><%=c.getNomeCorsista()%></td>
						<td><%=c.getCognomeCorsista()%></td>
						<td>
							<!-- Modal -->
							<div class="modal fade" id="modal<%=c.getIdCorsista()%>"
								tabindex="-1" role="dialog"
								aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header text-center"
											style="color: white; background-color: #1F2041;">
											<h2 class="modal-title w-100" id="exampleModalLongTitle">
												Corsi di
												<%=c.getNomeCorsista()%>&nbsp;<%=c.getCognomeCorsista()%></h2>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" style="background-color: #3C3D7C;">
											<%
												for (CorsoCorsista cc : corsiCorsisti) {
												Corso corso = AdminFacade.getInstance().getCorsoById(cc.getIdCorso());
												Docente docente = AdminFacade.getInstance().getDocenteById(corso.getIdDocente());
											%>
											<table class="table">
												<tr>
													<td colspan="2" style="text-align: center;"><h3 <%= corso.getDataFine().before(new Date()) ? "class='c-finito'" : "" %>><%=corso.getNomeCorso()%></h3></td>
												</tr>
												<tr>
													<td>Data inizio corso:</td>
													<td><%=formato.format(corso.getDataInizio())%></td>
												</tr>
												<tr>
													<td>Data fine corso:</td>
													<td><%=formato.format(corso.getDataFine())%></td>
												</tr>
												<tr>
													<td>Costo:</td>
													<td><%=corso.getCosto()%>&euro;</td>
												</tr>
												<tr>
													<td>Aula:</td>
													<td><%=corso.getAulaCorso()%></td>
												</tr>
												<tr>
													<td>Docente:</td>
													<td><%=docente.getNomeDocente()%>&nbsp;<%=docente.getCognomeDocente()%></td>
												</tr>
											</table>
											<hr>
											<br>
											<%
												}
											%>
										</div>
										<div class="modal-footer" style="background-color: #1F2041;">
											<button type="button" class="btn btn-primary"
												data-dismiss="modal">Chiudi</button>
										</div>
									</div>
								</div>
							</div>

						</td>
					</tr>

					<%
						}
					}
					%>
				</tbody>
			</table>

		</div>

		<%
			} else if (stat.equals("docen")) {
		Docente docente = AdminFacade.getInstance().getDocentePiuFormati();
		if (docente != null) {
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
						<td><%=docente.getNomeDocente()%>
						<td>
						<td><%=docente.getCognomeDocente()%></td>
						<td><%=docente.getCvDocente()%></td>
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
						for (Corso c : corsiDisp) {
						int numeroIscritti = AdminFacade.getInstance().getCorsoCorsistaByCorsoId(c.getIdCorso()).length;
					%>
					<tr>
						<td><%=c.getNomeCorso()%></td>
						<td><%=formato.format(c.getDataInizio())%></td>
						<td><%=formato.format(c.getDataFine())%></td>
						<td><%=c.getCosto()%>&euro;</td>
						<td><%=c.getCommentiCorso()%></td>
						<td><%=c.getAulaCorso()%></td>
						<td><%=numeroIscritti%>/12</td>
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