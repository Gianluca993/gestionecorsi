package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsoIdGenerator;
import it.betacom.business.model.Corso;

public class CorsoBC {

	private Connection conn;
	CorsoIdGenerator idGen;

	public CorsoBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Corso getById(long id) throws SQLException {
		return CorsoDAO.getFactory().getById(conn, id);
	}

	public Corso[] getAll() throws SQLException {
		return CorsoDAO.getFactory().getAll(conn);
	}

	public void create(Corso c) throws SQLException {
		CorsoDAO.getFactory().create(conn, c);
	}

	public void update(Corso c) throws SQLException {
		CorsoDAO.getFactory().update(conn, c);
	}

	public void delete(long id) throws SQLException {
		CorsoDAO.getFactory().delete(conn, id);
	}
}
