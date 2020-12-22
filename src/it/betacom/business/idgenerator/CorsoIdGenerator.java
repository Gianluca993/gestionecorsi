package it.betacom.business.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DBAccess;

public class CorsoIdGenerator implements GeneralIdGenerator{

	private static CorsoIdGenerator idGenerator;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private CorsoIdGenerator() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public CorsoIdGenerator getInstance() throws ClassNotFoundException, SQLException, IOException {
		if(idGenerator == null) {
			idGenerator = new CorsoIdGenerator();
		}
		return idGenerator;
	}
	
	@Override
	public long nextId() throws ClassNotFoundException, IOException, SQLException {
		long id = 0;
		stmt = conn.createStatement();
		//TODO query
		rs = stmt.executeQuery("");
		rs.next();
		id = rs.getLong(1);
		return id;
	}
}
