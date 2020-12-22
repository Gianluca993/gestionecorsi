package test.it.betacom.architecture.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.AdminDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.Admin;

class AdminDAOTest {
	
	Connection conn;

	@Test
	void testGetById() throws SQLException, ClassNotFoundException, IOException {
		AdminDAO adminDAO = AdminDAO.getFactory();
		conn = DBAccess.getConnection();
		Admin admin = adminDAO.getById(conn, 1);
		System.out.println(admin.toString());

	}


}
