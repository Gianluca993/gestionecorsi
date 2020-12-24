<%
	if(session.getAttribute("cognome") == null) {
		response.sendRedirect("accessonegato.jsp");
	}
%>