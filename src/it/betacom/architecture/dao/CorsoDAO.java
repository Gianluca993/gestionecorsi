package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.business.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants{

	public static CorsoDAO getFactory() throws SQLException {
		return new CorsoDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsoDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corso entity) throws SQLException {
		rowSet.setCommand(CORSO_GETALL);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getIdCorso());
		rowSet.updateString(2, entity.getNomeCorso());
		rowSet.updateDate(3, new java.sql.Date(entity.getDataInizio().getTime()));
		rowSet.updateDate(4, new java.sql.Date(entity.getDataFine().getTime()));
		rowSet.updateDouble(5, entity.getCosto());
		rowSet.updateString(6, entity.getCommentiCorso());
		rowSet.updateInt(7, entity.getAulaCorso());
		rowSet.updateLong(8, entity.getIdDocente());
		rowSet.insertRow();
		rowSet.acceptChanges();
	}

	@Override
	public void update(Connection conn, Corso entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso getById(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
