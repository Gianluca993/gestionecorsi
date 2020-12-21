package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;

public class CorsistaBC {
	private Connection conn;
	//TODO id generator
	
	public CorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
}
