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
import it.betacom.business.model.CorsoCorsista;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/modificacorsista")
public class ModificaCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = new Corsista();
		long id = Long.parseLong(request.getParameter("idCorsista"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		boolean prec = Integer.parseInt(request.getParameter("prec")) == 1;
		long corsoId = Long.parseLong(request.getParameter("corso"));
		corsista.setIdCorsista(id);
		corsista.setNomeCorsista(nome);
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecFormativi(prec);
		try {
			CorsoCorsista lastCorso = AdminFacade.getInstance().getLastCorsoCorsistaByCorsistaId(id);
			AdminFacade.getInstance().updateCorsista(corsista);
			if(lastCorso.getIdCorso() == corsoId) {
				CorsoCorsista newCorso = new CorsoCorsista();
				newCorso.setIdCorso(corsoId);
				newCorso.setIdCorsista(id);
				AdminFacade.getInstance().createCorsoCorsista(newCorso);
			}
			response.sendRedirect("daticorsisti.jsp");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
