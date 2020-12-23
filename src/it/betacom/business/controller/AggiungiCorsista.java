package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.business.AdminFacade;
import it.betacom.business.model.Corsista;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/aggiungicorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = new Corsista();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		boolean prec = Integer.parseInt(request.getParameter("prec")) == 1;
		corsista.setNomeCorsista(nome);
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecFormativi(prec);
		try {
			AdminFacade.getInstance().createCorsista(corsista);
			response.sendRedirect("listacorsi.jsp");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
