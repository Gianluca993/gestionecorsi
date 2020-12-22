package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.business.model.Docente;

public abstract class AdapterDocenteDAO implements GenericDAO<Docente> {

	@Override
	public Docente getById(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Connection conn, Docente entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Docente entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
