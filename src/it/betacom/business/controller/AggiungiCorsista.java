package it.betacom.business.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/aggiungicorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("nome");
		request.getParameter("cognome");
	}

}
