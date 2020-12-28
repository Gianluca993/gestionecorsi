package it.betacom.architecture.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.adapter.AdapterDocenteDAO;
import it.betacom.business.model.Docente;
import it.betacom.business.util.CVReader;

public class DocenteDAO extends AdapterDocenteDAO{

	public static DocenteDAO getFactory() throws SQLException {
		return new DocenteDAO();
	}
	
	@Override
	public Docente getById(Connection conn, long id) throws SQLException {
		Docente docente = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(DOCENTE);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			docente = new Docente();
			docente.setIdDocente(rs.getLong(1));
			docente.setNomeDocente(rs.getString(2));
			docente.setCognomeDocente(rs.getString(3));
			docente.setCvDocente(rs.getString(4));
		}
		return docente;
	}

	
	public Docente[] getAll(Connection conn) throws SQLException {
		Docente[] docenti = null;
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(DOCENTE_GETALL);
		rs.last();
		docenti = new Docente[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++) {
			Docente d = new Docente();
			d.setIdDocente(rs.getLong(1));
			d.setNomeDocente(rs.getNString(2));
			d.setCognomeDocente(rs.getString(3));
			d.setCvDocente(rs.getString(4));
			docenti[i] = d;
		}
		return docenti;
	}
	
	public Docente getDocenteByCorsi (Connection conn) throws SQLException, IOException {
		return CVReader.countCV(getAll(conn));
	}
}
