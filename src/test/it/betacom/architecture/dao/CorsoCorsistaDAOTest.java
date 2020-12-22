package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.Corsista;
import it.betacom.business.model.Corso;
import it.betacom.business.model.CorsoCorsista;
import it.betacom.business.model.Docente;

class CorsoCorsistaDAOTest {
	static Connection conn;
	static Corso corso;
	static Corsista corsista;
	static Docente docente;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setNomeCorso("Java");
		corso.setDataInizio(new Date());
		corso.setDataFine(new Date());
		corso.setCosto(1000);
		corso.setCommentiCorso("Commenti del corso JAVA");
		corso.setAulaCorso(2);
		corso.setIdDocente(1);
		
		corsista = new Corsista();
		corsista.setNomeCorsista("gigio");
		corsista.setCognomeCorsista("topo");
		corsista.setPrecFormativi(false);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Statement stmt = conn.createStatement();
		stmt.execute("delete corsi_corsisti where corso_id = " + corso.getIdCorso());
		stmt.close();
		CorsistaDAO.getFactory().delete(conn, corsista.getIdCorsista());
		CorsoDAO.getFactory().delete(conn, corso.getIdCorso());
		DBAccess.closeConnection();
		corso = null;
		corsista = null;
	}

	@Test
	void testCreateCorsoCorsista() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Creato Corso");
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Creato Corsista");
			
			CorsoCorsista cc = new CorsoCorsista();
			cc.setIdCorso(corso.getIdCorso());
			cc.setIdCorsista(corsista.getIdCorsista());
			
			CorsoCorsistaDAO.getFactory().create(conn, cc);
			System.out.println("Creato Corso-Corsista");
			
		} catch (Exception e) {
			fail("create fallito");
		}
	}

}
