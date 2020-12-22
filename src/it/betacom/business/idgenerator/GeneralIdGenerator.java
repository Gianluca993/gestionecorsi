package it.betacom.business.idgenerator;

import java.io.IOException;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOConstants;

public interface GeneralIdGenerator extends DAOConstants{

	long nextId() throws ClassNotFoundException, IOException, SQLException;
	
}
