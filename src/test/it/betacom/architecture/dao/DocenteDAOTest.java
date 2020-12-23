package test.it.betacom.architecture.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.business.model.Docente;

class DocenteDAOTest {


	Connection conn;

	@Test
	void testGetById() throws SQLException, ClassNotFoundException, IOException {
		DocenteDAO docenteDAO = DocenteDAO.getFactory();
		conn = DBAccess.getConnection();
		Docente docente = docenteDAO.getById(conn, 1);
		System.out.println(docente.toString());

	}
	
	@Test
	void testGetAll() throws ClassNotFoundException, SQLException, IOException {
		DocenteDAO docenteDAO = DocenteDAO.getFactory();
		conn = DBAccess.getConnection();
		Docente[] docenti = docenteDAO.getAll(conn);
		for(Docente d : docenti) {
			System.out.println("DOCENTE: " + d.toString());
		}
	}
	
	@Test
	void testGetDocenteByCV() throws SQLException, ClassNotFoundException, IOException {
		DocenteDAO docenteDAO = DocenteDAO.getFactory();
		conn = DBAccess.getConnection();
		Docente doc = docenteDAO.getDocenteByCorsi(conn);
		System.out.println("ID del docente: " + doc.getIdDocente());
	}

}
