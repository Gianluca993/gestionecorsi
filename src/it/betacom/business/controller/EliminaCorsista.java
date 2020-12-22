package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import it.betacom.business.AdminFacade;
import it.betacom.business.model.Corsista;

/**
 * Servlet implementation class AggiungiCorsista
 */
@WebServlet("/eliminacorsista/{id}")
public class EliminaCorsista extends HttpServlet {
	private static final long serialVersionUID = -1732386572633584297L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response, @PathParam(value="id") String ids) throws ServletException, IOException {
		long id = Long.parseLong(ids);
		try {
			AdminFacade.getInstance().deleteCorsista(id);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
