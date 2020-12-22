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
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 3570454550821941657L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("cognome") != null) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else 
			response.sendRedirect("accessonegato.jsp");
	}

}
