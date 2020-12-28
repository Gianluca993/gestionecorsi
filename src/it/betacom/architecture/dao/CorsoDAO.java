package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
		
	}

	@Override
	public void update(Connection conn, Corso entity) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPD_CORSO);
		ps.setString(1, entity.getNomeCorso());
		ps.setDate(2, new java.sql.Date(entity.getDataInizio().getTime()));
		ps.setDate(3, new java.sql.Date(entity.getDataFine().getTime()));
		ps.setDouble(4, entity.getCosto());
		ps.setString(5, entity.getCommentiCorso());
		ps.setInt(6, entity.getAulaCorso());
		ps.setLong(7, entity.getIdDocente());
		ps.setLong(8, entity.getIdCorso());
		ps.execute();
		conn.commit();
	}

	@Override
	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DEL_CORSO);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();
		
	}

	@Override
	public Corso getById(Connection conn, long id) throws SQLException {
		Corso corso = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(CORSO);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			corso = new Corso();
			corso.setIdCorso(rs.getLong(1));
			corso.setNomeCorso(rs.getString(2));
			corso.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			corso.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			corso.setCosto(rs.getDouble(5));
			corso.setCommentiCorso(rs.getString(6));
			corso.setAulaCorso(rs.getInt(7));
			corso.setIdDocente(rs.getLong(8));
		}
		
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws SQLException {
		Corso corsi[] = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSO_GETALL);
		rs.last();
		
		
		corsi = new Corso[rs.getRow()];
		
		rs.beforeFirst();
		
		for(int i = 0; rs.next(); i++) {
			Corso c = new Corso();
			c.setIdCorso(rs.getLong(1));
			c.setNomeCorso(rs.getString(2));
			c.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			c.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			c.setCosto(rs.getDouble(5));
			c.setCommentiCorso(rs.getString(6));
			c.setAulaCorso(rs.getInt(7));
			c.setIdDocente(rs.getLong(8));
			corsi[i] = c;
		}
		rs.close();
		return corsi;
		
	}

	public Corso getCorsoPiuFreq(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(CORSO_MAXFREQ);
		Corso c = null;
		if(rs.next()) {
			c = getById(conn, rs.getLong(1));
		}
		return c;
			
	}
	
	public Corso getDataUltimoCorso(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(DATA_INIZIO_LASTC);
		Corso c = null;
		if(rs.next())
			c = getById(conn, rs.getLong(1));
		return c;
	}
	
	public int getDurataMediaCorsi(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(DURATA_MEDIA);
		int durata = 0;
		if(rs.next())
			durata = (int) Math.round(rs.getDouble(1)/8);
		return durata;
	}
	
	public Corso[] getCorsiDisponibili(Connection conn) throws SQLException {
		Corso[] corsi = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(CORSI_POSTI_LIBERI);
		rs.last();
		corsi = new Corso[rs.getRow()];		
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			Corso c = getById(conn, rs.getLong(1));
			corsi[i] = c;
		}
		return corsi;
	}
}
