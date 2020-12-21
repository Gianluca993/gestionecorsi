package it.betacom.business;

public class AdminFacade {
	private static AdminFacade adminFacade;
	
	private AdminFacade() {
		
	}
	
	public AdminFacade getInstance() {
		if (adminFacade == null)
			adminFacade = new AdminFacade();
		return adminFacade;
	}
}
