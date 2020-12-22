package it.betacom.business.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOConst;
import it.betacom.architecture.dao.DBAccess;

public class CheckLogin implements DAOConst {
	
	public static CheckLogin getFactory() throws SQLException, ClassNotFoundException, IOException {
		return new CheckLogin();
	}

	private Connection conn;

	private CheckLogin() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getAdminId(String cognome) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("");
		ps.setString(1, cognome);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString(1);
		}
		return null;
	}
}
