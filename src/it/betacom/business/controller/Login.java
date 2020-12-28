package it.betacom.business.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.business.model.LoginData;
import it.betacom.business.util.CheckLogin;
import it.betacom.business.util.CountLogin;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 3570454550821941657L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		new CountLogin(request);
		ServletContext context = request.getServletContext();
		LoginData lD = (LoginData) context.getAttribute(request.getRemoteAddr());
		String cognome = request.getParameter("cognome");
		long id = Long.parseLong(request.getParameter("id"));
		long adminId = 0;
		if(lD == null || lD.getCount() < 5) {
			if (cognome != null && id > 0) {
				try {
					adminId = CheckLogin.getFactory().getAdminId(cognome);
					if(adminId != 0 && adminId == id) {
						session.setAttribute("cognome", cognome);
						context.removeAttribute(request.getRemoteAddr());
						response.sendRedirect("daticorsisti.jsp");
					} else {
						response.sendRedirect("index.jsp");
					}
				} catch (ClassNotFoundException | SQLException | IOException e) {
					e.printStackTrace();
					throw new ServletException(e.getMessage());
				}
			}
		} else {
			response.sendRedirect("loginfailed.jsp");
		}
	}

}
