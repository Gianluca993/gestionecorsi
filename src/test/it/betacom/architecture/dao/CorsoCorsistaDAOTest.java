package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DBAccess;

class CorsoCorsistaDAOTest {
	static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
