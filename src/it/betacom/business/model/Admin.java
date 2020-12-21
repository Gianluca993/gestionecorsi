package it.betacom.business.model;

public class Admin {
	private long idAdmin;
	private String nomeAdmin;
	private String cognomeAdmin;
	
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getCognomeAdmin() {
		return cognomeAdmin;
	}
	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin + "]";
	}
	
	
	
}
