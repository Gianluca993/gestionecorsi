package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;

public class DocenteBC {

	private Connection conn;
	//TODO id generator
	
	public DocenteBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
}
