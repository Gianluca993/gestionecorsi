package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.architecture.dao.adapter.AdapterCorsoCorsistaDAO;
import it.betacom.business.model.CorsoCorsista;

public class CorsoCorsistaDAO extends AdapterCorsoCorsistaDAO {

	public static CorsoCorsistaDAO getFactory() throws SQLException {
		return new CorsoCorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, CorsoCorsista entity) throws SQLException {
		rowSet.setCommand(CORSI_CORSISTI_GETALL);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getIdCorso());
		rowSet.updateLong(2, entity.getIdCorsista());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws SQLException {
		CorsoCorsista[] cor = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSI_CORSISTI_GETALL);
		rs.last();
		cor = new CorsoCorsista[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			CorsoCorsista c = new CorsoCorsista();
			c.setIdCorso(rs.getLong(1));
			c.setIdCorsista(rs.getLong(2));
			cor[i] = c;
		}
		return cor;
	}
	
	public CorsoCorsista[] getByCorsoId(Connection conn, long corsoId) throws SQLException {
		CorsoCorsista[] cor = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSICORSISTI_CORSOID);
		rs.last();
		cor = new CorsoCorsista[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			CorsoCorsista c = new CorsoCorsista();
			c.setIdCorso(rs.getLong(1));
			c.setIdCorsista(rs.getLong(2));
			cor[i] = c;
		}
		return cor;
	}
	
	public CorsoCorsista[] getByCorsistaId(Connection conn, long corsoId) throws SQLException {
		CorsoCorsista[] cor = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSICORSISTI_CORSISTAID);
		rs.last();
		cor = new CorsoCorsista[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			CorsoCorsista c = new CorsoCorsista();
			c.setIdCorso(rs.getLong(1));
			c.setIdCorsista(rs.getLong(2));
			cor[i] = c;
		}
		return cor;
	}
}
