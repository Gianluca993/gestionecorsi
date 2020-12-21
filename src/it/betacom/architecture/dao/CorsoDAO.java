package it.betacom.architecture.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CorsoDAO {

	public static CorsoDAO getFactory() throws SQLException {
		return new CorsoDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsoDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
}
