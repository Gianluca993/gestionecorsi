package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.architecture.dao.adapter.AdapterDocenteDAO;
import it.betacom.business.model.Docente;

public class DocenteDAO extends AdapterDocenteDAO{

	public static DocenteDAO getFactory() throws SQLException {
		return new DocenteDAO();
	}
	
	@Override
	public Docente getById(Connection conn, long id) throws SQLException {
		Docente docente = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(DOCENTE_GETALL);
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
	
}
