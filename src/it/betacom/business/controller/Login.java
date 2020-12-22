package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.business.util.CheckLogin;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 3570454550821941657L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cognome = request.getParameter("cognome");
		String id = request.getParameter("id");
		String adminId = null;
		if (cognome != null && id != null) {
			try {
				adminId = CheckLogin.getFactory().getAdminId(cognome);
				if(adminId != null && adminId.equals(id)) {
					session.setAttribute("cognome", cognome);
					response.sendRedirect("/");
					//TODO redirect
				}
			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
		}
	}

}
