package it.betacom.business.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DBAccess;

public class CheckLogin implements DAOConstants {
	
	public static CheckLogin getFactory() throws SQLException, ClassNotFoundException, IOException {
		return new CheckLogin();
	}

	private Connection conn;

	private CheckLogin() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public long getAdminId(String cognome) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(GET_ADMINID);
		ps.setString(1, cognome);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getLong(1);
		}
		return 0;
	}
}
