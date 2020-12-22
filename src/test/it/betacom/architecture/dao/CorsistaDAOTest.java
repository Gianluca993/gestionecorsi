package test.it.betacom.architecture.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsistaIdGenerator;
import it.betacom.business.model.Corsista;

class CorsistaDAOTest {
	
	static Connection conn;
	static Corsista corsista1;
	static Corsista corsista2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		CorsistaIdGenerator idGenerator = CorsistaIdGenerator.getInstance();
		corsista1 = new Corsista();
		corsista1.setIdCorsista(idGenerator.nextId());
		corsista1.setNomeCorsista("Mario");
		corsista1.setCognomeCorsista("Verdi");
		corsista1.setPrecFormativi(true);
		System.out.println("CORSISTA 1 PER IL TEST: " + corsista1.toString());
		
		corsista2 = new Corsista();
		corsista2.setIdCorsista(idGenerator.nextId());
		corsista2.setNomeCorsista("Paolo");
		corsista2.setCognomeCorsista("Rossi");
		corsista2.setPrecFormativi(true);
		System.out.println("CORSISTA 2 PER IL TEST: " + corsista2.toString());
	}

	@Test
	void testCreate() throws SQLException {
		System.out.println();
		System.out.println("Test create()/getById()");
		CorsistaDAO corsistaDAO = CorsistaDAO.getFactory();
		corsistaDAO.create(conn, corsista1);
		Corsista c1 = corsistaDAO.getById(conn, corsista1.getIdCorsista());
		System.out.println("Corsista 1 creato --> " + c1.toString());
		
		corsistaDAO.create(conn, corsista2);
		Corsista c2 = corsistaDAO.getById(conn, corsista2.getIdCorsista());
		System.out.println("Corsista 2 creato --> " + c2.toString());
	}
	
	@Test
	void testUpdate() throws SQLException, ClassNotFoundException, IOException {
		System.out.println();
		System.out.println("Test update()");
		CorsistaDAO corsistaDAO = CorsistaDAO.getFactory();
		Corsista c = new Corsista();
		c.setIdCorsista(corsista1.getIdCorsista());
		c.setNomeCorsista("Mario");
		c.setCognomeCorsista("Gialli");
		c.setPrecFormativi(false);
		
		corsistaDAO.update(conn, c);
		Corsista c1 = corsistaDAO.getById(conn, c.getIdCorsista());
		System.out.println("CORSISTA AGGIORNATO --> " + c1.toString());
	}
	
	@Test
	void testGetAll() throws SQLException, ClassNotFoundException, IOException {
		System.out.println();
		System.out.println("Test getAll()");
		Corsista corsisti[] = null;
		CorsistaDAO corsistaDAO = CorsistaDAO.getFactory();
		
		corsisti = corsistaDAO.getAll(conn);
		for(Corsista c: corsisti) {
			System.out.println("CORSISTA: " + c.toString());
		}
		}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.printf("\nTest delete()\n");
		CorsistaDAO corsistaDAO = CorsistaDAO.getFactory();
		corsistaDAO.delete(conn, corsista1.getIdCorsista());
		System.out.println("Corsista 1 eliminato");
		
		corsistaDAO.delete(conn, corsista2.getIdCorsista());
		System.out.println("Corsista 2 eliminato");
		conn.close();
	}

}
