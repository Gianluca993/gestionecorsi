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

@WebServlet("/modificaCorso")
public class ModificaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Corso corso = new Corso();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String cognome = (String) session.getAttribute("cognome");
		if(cognome != null) {
			String nomeCorso = request.getParameter("nomeCorsoUP");
			String dataInizio = request.getParameter("dataInizioUP");
			String dataFine = request.getParameter("dataFineUP");
			String aulaCorso = request.getParameter("aulaCorsoUP");
			String costo = request.getParameter("costoCorsoUP");
			String idCorso = request.getParameter("idCorsoUP");
			String idDocente = request.getParameter("idDocenteUP");
			try {
				corso.setNomeCorso(nomeCorso);
				corso.setDataInizio(formato.parse(dataInizio));
				corso.setDataFine(formato.parse(dataFine));
				corso.setAulaCorso(Integer.parseInt(aulaCorso));
				corso.setCosto(Double.parseDouble(costo));
				corso.setIdCorso(Integer.parseInt(idCorso));
				corso.setIdDocente(Integer.parseInt(idDocente));
				AdminFacade.getInstance().updateCorso(corso);
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
