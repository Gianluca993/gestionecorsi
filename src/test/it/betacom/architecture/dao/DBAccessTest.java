package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DBAccess;

class DBAccessTest {


	@Test
	void test() {
		try {
			Connection con=DBAccess.getConnection();
			if(con==null)
				fail("connessione null");
			else
				System.out.println("tutto nella norma");
			
			DBAccess.closeConnection();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			fail("ops");
			e.printStackTrace();
		}
		
	}
	
	

}
