package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.idgenerator.CorsistaIdGenerator;
import it.betacom.business.idgenerator.CorsoIdGenerator;
import it.betacom.business.model.Corsista;
import it.betacom.business.model.Corso;
import it.betacom.business.model.CorsoCorsista;
import it.betacom.business.model.Docente;

class CorsoCorsistaDAOTest {
	static Connection conn;
	static Corso corso;
	static Corsista corsista;
	static Docente docente;
	static CorsoIdGenerator idCorsoGenerator;
	static CorsistaIdGenerator idCorsistaGenerator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		idCorsoGenerator = CorsoIdGenerator.getInstance();
		idCorsistaGenerator = CorsistaIdGenerator.getInstance();
		corso = new Corso();
		corso.setIdCorso(idCorsoGenerator.nextId());
		corso.setNomeCorso("Java");
		corso.setDataInizio(new Date());
		corso.setDataFine(new Date());
		corso.setCosto(1000);
		corso.setCommentiCorso("Commenti del corso JAVA");
		corso.setAulaCorso(2);
		corso.setIdDocente(1);
		System.out.println("CORSO PER IL TEST: " + corso.toString());
		
		corsista = new Corsista();
		corsista.setIdCorsista(idCorsistaGenerator.nextId());
		corsista.setNomeCorsista("gigio");
		corsista.setCognomeCorsista("topo");
		corsista.setPrecFormativi(false);
		System.out.println("CORSISTA PER IL TEST: " + corsista.toString());
	}



	@Test
	void testCreateCorsoCorsista() {
		System.out.printf("Test create()/getById()\n");
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Creato Corso");
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Creato Corsista");
			
			System.out.printf("\n -- Creando CorsoCorsista -- \n");
			CorsoCorsista cc = new CorsoCorsista();
			cc.setIdCorso(corso.getIdCorso());
			cc.setIdCorsista(corsista.getIdCorsista());
			
			CorsoCorsistaDAO.getFactory().create(conn, cc);
			System.out.println("Creato CorsoCorsista");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Create fallito");
		}
	}
	
	@Test
	void testGetByCorsoId() throws SQLException {
		CorsoCorsista corsoCorsisti[] = CorsoCorsistaDAO.getFactory().getByCorsoId(conn, corso.getIdCorso());
		for(CorsoCorsista c: corsoCorsisti) {
			System.out.println("CorsoCorsista: " + c.toString());
		}
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Statement stmt = conn.createStatement();
		stmt.execute("delete corsi_corsisti where id_corso = " + corso.getIdCorso());
		stmt.close();
		System.out.println("delete corsi_corsisti");
		CorsistaDAO.getFactory().delete(conn, corsista.getIdCorsista());
		System.out.println("delete corsisti");
		CorsoDAO.getFactory().delete(conn, corso.getIdCorso());
		System.out.println("delete corso");
		DBAccess.closeConnection();
		corso = null;
		corsista = null;
	}

}
