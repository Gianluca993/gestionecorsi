package it.betacom.architecture.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CorsistaDAO {

	public static CorsistaDAO getFactory() throws SQLException {
		return new CorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
}
