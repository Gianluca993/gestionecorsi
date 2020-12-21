package it.betacom.business.idgenerator;

import java.io.IOException;
import java.sql.SQLException;

public interface GeneralIdGenerator {

	long nextId() throws ClassNotFoundException, IOException, SQLException;
	
}
