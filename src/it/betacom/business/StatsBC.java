package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.business.model.Corsista;
import it.betacom.business.model.Corso;
import it.betacom.business.model.Docente;

public class StatsBC {
	Connection conn;

	public StatsBC() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}
	
	// CORSI
	public Corso getCorsoPiuFreq() throws SQLException {
		return CorsoDAO.getFactory().getCorsoPiuFreq(conn);
	}
	
	public Corso getDataUltimoCorso() throws SQLException {
		return CorsoDAO.getFactory().getDataUltimoCorso(conn);
	}
	
	public int getDurataMediaCorsi() throws SQLException {
		return CorsoDAO.getFactory().getDurataMediaCorsi(conn);
	}
	
	public int getNumeroCommenti() throws SQLException {
		return CorsoDAO.getFactory().getAll(conn).length;
	}
	
	public Corso[] getCorsiDisponibili() throws SQLException {
		return CorsoDAO.getFactory().getCorsiDisponibili(conn);
	}
	
	// CORSISTI
	public int getConteggioCorsisti() throws SQLException {
		Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
		return corsisti.length;
	}
	
	public Corsista[] getElencoCorsisti() throws SQLException {
		return CorsistaDAO.getFactory().getAll(conn);
	}
	
	// DOCENTI
	public Docente getDocentePiuFormati() throws SQLException, IOException {
		return DocenteDAO.getFactory().getDocenteByCorsi(conn);
	}
	
}
