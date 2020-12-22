package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.business.model.Docente;

public class DocenteBC {

	private Connection conn;
	
	public DocenteBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Docente getById(long id) throws SQLException {
		return DocenteDAO.getFactory().getById(conn, id);
	}
	
	public Docente[] getAll() throws SQLException {
		return DocenteDAO.getFactory().getAll(conn);
	}
}
