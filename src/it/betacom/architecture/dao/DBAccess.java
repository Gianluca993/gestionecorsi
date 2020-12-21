package it.betacom.architecture.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Classe per la gestione dell'accesso al DataBase
public class DBAccess {
	private static Connection conn;
	
	public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("properties/config.properties");
			Properties p = new Properties();
			p.load(input);
			Class.forName(p.getProperty("jdbcDriver"));
			conn = DriverManager.getConnection(
					p.getProperty("jdbcUrl"), 
					p.getProperty("jdbcUsername"),
					p.getProperty("jdbcPassword"));
			conn.setAutoCommit(false);
		return conn;
	}

	public static void closeConnection() throws SQLException {
		conn.close();
	}

	
}
