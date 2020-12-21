package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.business.model.Admin;

public abstract class AdapterAdminDAO implements GenericDAO<Admin> {

	@Override
	public void create(Connection conn, Admin entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection conn, Admin entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin getById(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
