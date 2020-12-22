package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.business.AdminFacade;

<<<<<<< HEAD
@WebServlet("/eliminacorsista/{id}")
=======
/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/eliminacorsista")
>>>>>>> 500ea74cef25565b3279d5bb53822b2c7f4798a2
public class EliminaCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		try {
			AdminFacade.getInstance().deleteCorsista(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
