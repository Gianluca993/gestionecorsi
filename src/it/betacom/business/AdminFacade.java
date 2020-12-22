package it.betacom.business;

import java.io.IOException;
import java.sql.SQLException;

import it.betacom.business.model.Admin;
import it.betacom.business.model.Corsista;
import it.betacom.business.model.Corso;
import it.betacom.business.model.CorsoCorsista;
import it.betacom.business.model.Docente;

public class AdminFacade {
	private static AdminFacade adminFacade;
	AdminBC adminBC;
	CorsistaBC corsistaBC;
	CorsoBC corsoBC;
	CorsoCorsistaBC corsoCorsistaBC;
	DocenteBC docenteBC;
	
	private AdminFacade() throws ClassNotFoundException, SQLException, IOException {
		adminBC = new AdminBC();
		corsistaBC = new CorsistaBC();
		corsoBC = new CorsoBC();
		corsoCorsistaBC = new CorsoCorsistaBC();
		docenteBC = new DocenteBC();
	}
	
	public AdminFacade getInstance() throws ClassNotFoundException, SQLException, IOException {
		if (adminFacade == null)
			adminFacade = new AdminFacade();
		return adminFacade;
	}
	
	// ADMIN
	public Admin getAdminById(long id) throws SQLException {
		return adminBC.getById(id);
	}
	
	// CORSISTA
	public Corsista getCorsistaById(long id) throws SQLException {
		return corsistaBC.getById(id);
	}
	public Corsista[] getAllCorsisti() throws SQLException {
		return corsistaBC.getAll();
	}
	public void createCorsista(Corsista c) throws SQLException {
		corsistaBC.create(c);
	}
	public void updateCorsista(Corsista c) throws SQLException {
		corsistaBC.update(c);
	}
	public void deleteCorsista(long id) throws SQLException {
		corsistaBC.delete(id);
	}
	
	// CORSO
	public Corso getCorsoById(long id) throws SQLException {
		return corsoBC.getById(id);
	}
	public Corso[] getAllCorsi() throws SQLException {
		return corsoBC.getAll();
	}
	public void createCorso(Corso c) throws SQLException {
		corsoBC.create(c);
	}
	public void updateCorso(Corso c) throws SQLException {
		corsoBC.update(c);
	}
	public void deleteCorso(long id) throws SQLException {
		corsoBC.delete(id);
	}
	
	// CORSO-CORSISTA
	public CorsoCorsista[] getCorsoCorsistaByCorsoId(long id) throws SQLException {
		return corsoCorsistaBC.getByCorsoId(id);
	}
	public CorsoCorsista[] getCorsoCorsistaByCorsistaId(long id) throws SQLException {
		return corsoCorsistaBC.getByCorsistaId(id);
	}
	public void createCorsoCorsista(CorsoCorsista c) throws SQLException {
		corsoCorsistaBC.create(c);
	}
	
	//DOCENTE
	public Docente getDocenteById(long id) throws SQLException {
		return docenteBC.getById(id);
	}
	public Docente[] getAllDocenti() throws SQLException {
		return docenteBC.getAll();
	}
	
}