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
	
	public Corsista[] getAll() throws SQLException {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	public void create(Corsista c) throws SQLException, ClassNotFoundException, IOException {
		if(c.getIdCorsista() > 0) {
			update(c);
		} else {
			idGen = CorsistaIdGenerator.getInstance();
			c.setIdCorsista(idGen.nextId());
			CorsistaDAO.getFactory().create(conn, c);							
		}			
	}
	
	public void update(Corsista c) throws SQLException {
		CorsistaDAO.getFactory().update(conn, c);
	}
	
	public void delete(long id) throws SQLException {
		CorsistaDAO.getFactory().delete(conn, id);
	}
}
