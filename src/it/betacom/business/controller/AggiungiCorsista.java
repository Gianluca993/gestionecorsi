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
@WebServlet("/aggiungicorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corsista corsista = new Corsista();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		boolean prec = request.getParameter("prec") != null;
		long corsoId = Long.parseLong(request.getParameter("corso"));
		corsista.setNomeCorsista(nome);
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecFormativi(prec);
		
		CorsoCorsista cc = new CorsoCorsista();
		cc.setIdCorso(corsoId);
		try {
			int iscritti = AdminFacade.getInstance().getCorsoCorsistaByCorsoId(corsoId).length;
			if(iscritti < 12) {
				AdminFacade.getInstance().createCorsista(corsista);
				long idCorsista = corsista.getIdCorsista();
				cc.setIdCorsista(idCorsista);
				AdminFacade.getInstance().createCorsoCorsista(cc);
				response.sendRedirect("listacorsi.jsp");
			} else {
				response.sendRedirect("corsopieno.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
