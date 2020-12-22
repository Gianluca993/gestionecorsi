package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.business.AdminFacade;

@WebServlet("/eliminacorso/{id}")
public class EliminaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cognome = request.getParameter("cognome");
		if(cognome == session.getAttribute("cognome")) {
			long id = Long.parseLong(request.getParameter("idCorso"));
			try {
				AdminFacade.getInstance().deleteCorso(id);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
