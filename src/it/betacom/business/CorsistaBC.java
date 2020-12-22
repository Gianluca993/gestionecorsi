package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsistaIdGenerator;
import it.betacom.business.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	CorsistaIdGenerator idGen;
	
	public CorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Corsista getById(long id) {
		return null;
	}
	
	public Corsista[] getAll() {
		return null;
	}
	
	public void create(Corsista c) {
		
	}
	
	public void update(Corsista c) {
		
	}
	
	public void delete(long id) {
		
	}
}
