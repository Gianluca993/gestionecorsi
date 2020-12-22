package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.business.AdminFacade;
import it.betacom.business.model.Corso;

@WebServlet("/aggiungicorso")
public class AggiungiCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Corso corso = new Corso();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String cognome = (String) session.getAttribute("cognome");
		if(cognome != null) {
			try {
				corso.setNomeCorso(request.getParameter("nomeCorso"));
				corso.setDataInizio(formato.parse(request.getParameter("dataInizio")));
				corso.setDataFine(formato.parse(request.getParameter("dataFine")));
				corso.setAulaCorso(Integer.parseInt(request.getParameter("aulaCorso")));
				corso.setCosto(Double.parseDouble(request.getParameter("costoCorso")));
				corso.setIdCorso(Integer.parseInt(request.getParameter("idCorso")));
				corso.setIdDocente(Integer.parseInt(request.getParameter("idDocente")));
				AdminFacade.getInstance().createCorso(corso);
				response.sendRedirect("listacorsi.jsp");
			} catch(ParseException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("accessonegato.jsp");
		}
	}
}
