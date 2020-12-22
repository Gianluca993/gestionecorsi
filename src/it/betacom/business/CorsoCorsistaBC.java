package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.CorsoCorsista;

public class CorsoCorsistaBC {

	private Connection conn;
	//TODO id generator
	
	public CorsoCorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public CorsoCorsista getById(long id) {
		return null;
	}
	
	public CorsoCorsista[] getAll() {
		return null;
	}
	
	public void create(CorsoCorsista c) {
		
	}
	
	public void update(CorsoCorsista c) {
		
	}
	
	public void delete(long id) {
		
	}
}
