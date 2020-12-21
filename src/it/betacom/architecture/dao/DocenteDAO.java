package it.betacom.architecture.dao;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DocenteDAO {

	public static DocenteDAO getFactory() throws SQLException {
		return new DocenteDAO();
	}

	private CachedRowSet rowSet;
	
	private DocenteDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
}
