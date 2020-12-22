package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsoIdGenerator;

public class CorsoBC {

	private Connection conn;
	CorsoIdGenerator idGen;
	
	public CorsoBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
}
