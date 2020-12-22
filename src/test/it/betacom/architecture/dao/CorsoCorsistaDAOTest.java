package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.business.model.Corsista;
import it.betacom.business.model.Corso;
import it.betacom.business.model.CorsoCorsista;

class CorsoCorsistaDAOTest {
	static Connection conn;
	static Corso corso;
	static Corsista corsista;
	static CorsoCorsista corsoCorsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corso = new Corso();
		corso.setNomeCorso("Java");
		corso.setDataInizio(new Date());
		corso.setDataFine(new Date());
		corso.setCosto(1000);
		corso.setCommentiCorso("Commenti del corso JAVA");
		corso.setAulaCorso(2);
		corso.setIdDocente(1);
		System.out.println("CORSO 1 PER IL TEST: " + corso.toString());
		
		corsista = new Corsista();
		corsista.setNomeCorsista("gigio");
		corsista.setCognomeCorsista("topo");
		corsista.setPrecFormativi(false);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	void testCreateCorsoCorsista() {
		try {
			
		} catch (Exception e) {
			fail("create fallito");
		}
	}

}
