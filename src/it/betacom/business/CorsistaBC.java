package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsistaIdGenerator;
import it.betacom.business.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	CorsistaIdGenerator idGen;
	
	public CorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Corsista getById(long id) throws SQLException {
		return CorsistaDAO.getFactory().getById(conn, id);
	}
	
	public Corsista[] getAll() {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	public void create(Corsista c) {
		
	}
	
	public void update(Corsista c) {
		
	}
	
	public void delete(long id) {
		
	}
}
