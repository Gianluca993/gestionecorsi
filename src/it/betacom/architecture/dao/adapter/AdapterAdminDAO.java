package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.business.model.Admin;

public abstract class AdapterAdminDAO implements GenericDAO<Admin> {

	@Override
	public Admin getById(Connection conn, long id) throws SQLException {
		return null;
	}	

}
