package test.it.betacom.architecture.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsoIdGenerator;
import it.betacom.business.model.Corso;

class CorsoDAOTest {
	
	static Connection conn;
	static Corso corso1;
	static Corso corso2;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		conn = DBAccess.getConnection();
		
		CorsoIdGenerator idGenerator = CorsoIdGenerator.getInstance();
		
		corso1 = new Corso();
		corso1.setIdCorso(idGenerator.nextId());
		corso1.setNomeCorso("Java");
		corso1.setDataInizio(new Date());
		corso1.setDataFine(new Date());
		corso1.setCosto(1000);
		corso1.setCommentiCorso("Commenti del corso JAVA");
		corso1.setAulaCorso(2);
		corso1.setIdDocente(1);
		System.out.println("CORSO 1 PER IL TEST: " + corso1.toString());
		
		corso2 = new Corso();
		corso2.setIdCorso(idGenerator.nextId());
		corso2.setNomeCorso("Angular");
		corso2.setDataInizio(new Date());
		corso2.setDataFine(new Date());
		corso2.setCosto(800);
		corso2.setCommentiCorso("Commenti del corso ANGULAR");
		corso2.setAulaCorso(4);
		corso2.setIdDocente(1);
		System.out.println("CORSO 2 PER IL TEST: " + corso2.toString());
	}
	


	@Test
	void testCreate() throws SQLException, ClassNotFoundException, IOException {
		System.out.println();
		System.out.println("Test create()/getById()");
		CorsoDAO corsoDAO =  CorsoDAO.getFactory();
		corsoDAO.create(conn, corso1);
		Corso c1 = corsoDAO.getById(conn, corso1.getIdCorso());
		System.out.println("Corso 1 creato --> " + c1.toString());
		
		corsoDAO.create(conn, corso2);
		Corso c2 = corsoDAO.getById(conn, corso2.getIdCorso());
		System.out.println("Corso 2 creato --> " + c2.toString());
	}
	
	@Test
	void testUpdate() throws SQLException, ClassNotFoundException, IOException {
		System.out.println();
		System.out.println("Test update()");
		CorsoDAO corsoDAO =  CorsoDAO.getFactory();
		Corso c = new Corso();
		c.setIdCorso(corso1.getIdCorso());
		c.setNomeCorso("Java 2");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCosto(1200);
		c.setCommentiCorso("Commenti del corso JAVA 2");
		c.setAulaCorso(5);
		c.setIdDocente(1);
		
		corsoDAO.update(conn, c);
		Corso c1 = corsoDAO.getById(conn, c.getIdCorso());
		System.out.println("CORSO AGGIORNATO --> " + c1.toString());
	}
	
	
	@Test
	void testGetAll() throws SQLException, ClassNotFoundException, IOException {
		System.out.println();
		System.out.println("Test getAll()");
		Corso corsi[] = null;
		CorsoDAO corsoDAO = CorsoDAO.getFactory();
		corsi = corsoDAO.getAll(conn);
		for(Corso c : corsi) {
			System.out.println("CORSO: " + c.toString());
		}
	}
	
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println();
		System.out.println("Test delete()");
		CorsoDAO corsoDAO = CorsoDAO.getFactory();
		corsoDAO.delete(conn, corso1.getIdCorso());
		System.out.println("Corso 1 eliminato");
		
		corsoDAO.delete(conn, corso2.getIdCorso());
		System.out.println("Corso 2 eliminato");
		conn.close();
	}

}
