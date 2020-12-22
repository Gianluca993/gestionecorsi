package it.betacom.business.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import it.betacom.architecture.dao.DBAccess;

public class CorsistaIdGenerator implements GeneralIdGenerator{

	private static CorsistaIdGenerator idGenerator;

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsistaIdGenerator() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	@Override
	public long nextId() throws SQLException {
		long id = 0;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(CORSISTI_NEXTVAL);
		rs.next();
		id = rs.getLong(1);
		return id;
	}

	public static CorsistaIdGenerator getInstance() throws SQLException, ClassNotFoundException, IOException{
		if(idGenerator == null) {
			idGenerator = new CorsistaIdGenerator();
		}
		return idGenerator;
		
	}
}
