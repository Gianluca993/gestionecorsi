package it.betacom.business;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.Corso;

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
	
	public double getDurataMediaCorsi() throws SQLException {
		return CorsoDAO.getFactory().getDurataMediaCorsi(conn);
	}
	
	public void getNumeroCommenti() {
		
	}
	
	public Corso[] getCorsiDisponibili() throws SQLException {
		return CorsoDAO.getFactory().getCorsiDisponibili(conn);
	}
	
	// CORSISTI
	public void getConteggioCorsisti() {
		
	}
	
	public void getElencoCorsisti() {
		
	}
	
	// DOCENTI
	public void getDocentiPiuFormati() {
		
	}
	
}
