package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.AdminDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.Admin;


public class AdminBC {
	private Connection conn;
	
	public AdminBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Admin getById(long id) throws SQLException {
		return AdminDAO.getFactory().getById(conn, id);
	}
}
