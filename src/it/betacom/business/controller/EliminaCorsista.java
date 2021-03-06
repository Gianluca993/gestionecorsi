package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.business.AdminFacade;



@WebServlet("/eliminacorsista")
public class EliminaCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println("ID del corsista: " + id);
		try {
			AdminFacade.getInstance().deleteCorsista(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		response.sendRedirect("daticorsisti.jsp");
	}

}
