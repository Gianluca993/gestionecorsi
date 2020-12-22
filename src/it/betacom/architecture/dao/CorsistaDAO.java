package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.business.model.Corsista;

public class CorsistaDAO implements GenericDAO<Corsista>{

	public static CorsistaDAO getFactory() throws SQLException {
		return new CorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	private CorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corsista entity) throws SQLException {
		rowSet.setCommand(CORSISTI_GETALL);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateLong(1, entity.getIdCorsista());
		rowSet.updateString(2, entity.getNomeCorsista());
		rowSet.updateString(3, entity.getCognomeCorsista());
		rowSet.updateInt(4, entity.isPrecFormativi() ? 1 : 0);
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}

	@Override
	public void update(Connection conn, Corsista entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPD_CORSISTA);
		ps.setString(1, entity.getNomeCorsista());
		ps.setString(2, entity.getCognomeCorsista());
		ps.setInt(3, entity.isPrecFormativi()?1:0);
		ps.setLong(4, entity.getIdCorsista());
		ps.execute();
		
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DEL_CORSISTA);
		ps.setLong(3, id);
		ps.execute();
	}

	@Override
	public Corsista getById(Connection conn, long id) throws SQLException {
		Corsista c = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(CORSISTA);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			c = new Corsista();
			c.setIdCorsista(id);
			c.setNomeCorsista(rs.getString(2));
			c.setCognomeCorsista(rs.getString(3));
		}
		return c;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws SQLException {
		Corsista cor[] = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSISTI_GETALL);
		rs.last();
		cor = new Corsista[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			Corsista c = new Corsista();
			c.setIdCorsista(rs.getLong(1));
			c.setNomeCorsista(rs.getString(2));
			c.setCognomeCorsista(rs.getString(3));
			cor[i] = c;
		}
		return cor;
	}
}
