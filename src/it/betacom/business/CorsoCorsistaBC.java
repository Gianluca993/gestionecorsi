package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.CorsoCorsista;

public class CorsoCorsistaBC {

	private Connection conn;
	//TODO id generator
	
	public CorsoCorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	public CorsoCorsista getLastByCorsistaId(long id) throws SQLException {
		return CorsoCorsistaDAO.getFactory().getLastByCorsistaId(conn, id);
	}
	
	public CorsoCorsista[] getByCorsoId(long id) throws SQLException {
		return CorsoCorsistaDAO.getFactory().getByCorsoId(conn, id);
	}
	
	public CorsoCorsista[] getByCorsistaId(long id) throws SQLException {
		return CorsoCorsistaDAO.getFactory().getByCorsistaId(conn, id);
	}
	
	public CorsoCorsista[] getAll() throws SQLException {
		return CorsoCorsistaDAO.getFactory().getAll(conn);
	}
	
	public void create(CorsoCorsista c) throws SQLException {
		CorsoCorsistaDAO.getFactory().create(conn, c);
	}
	
}
