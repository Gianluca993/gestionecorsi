package it.betacom.business.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 3570454550821941657L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cognome = request.getParameter("cognome");
		String id = request.getParameter("id");
		String userpass = null;
		String adminpass = null;
		if (cognome != null && id != null) {
			
		}
	}

}
