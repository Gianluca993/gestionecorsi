package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.business.model.CorsoCorsista;

public abstract class AdapterCorsoCorsistaDAO implements GenericDAO<CorsoCorsista>{

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, CorsoCorsista entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getById(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
