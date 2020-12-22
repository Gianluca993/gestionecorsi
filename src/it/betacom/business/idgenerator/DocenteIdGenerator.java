package it.betacom.business.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import it.betacom.architecture.dao.DBAccess;

public class DocenteIdGenerator implements GeneralIdGenerator{
	
	private static DocenteIdGenerator idGenerator;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private DocenteIdGenerator() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}
	
	@Override
	public long nextId() throws ClassNotFoundException, IOException, SQLException {
		long id = 0;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(DOC_NEXTVAL);
		rs.next();
		id = rs.getLong(1);
		return id;
	}
	
	public static DocenteIdGenerator getInstance() throws ClassNotFoundException, SQLException, IOException {
		if(idGenerator == null) {
			idGenerator = new DocenteIdGenerator();
		}
		return idGenerator;
	}

}
