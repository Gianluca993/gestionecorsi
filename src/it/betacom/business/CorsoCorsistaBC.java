package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;

public class CorsoCorsistaBC {

	private Connection conn;
	//TODO id generator
	
	public CorsoCorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
}
