package it.betacom.architecture.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class AdminDAO {
	
	public static AdminDAO getFactory() throws SQLException {
		return new AdminDAO();
	}

	private CachedRowSet rowSet;
	
	private AdminDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

}
