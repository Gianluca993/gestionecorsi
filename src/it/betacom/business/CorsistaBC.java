package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsistaIdGenerator;

public class CorsistaBC {
	private Connection conn;
	CorsistaIdGenerator idGen;
	
	public CorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
}
