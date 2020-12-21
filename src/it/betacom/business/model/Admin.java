package it.betacom.business.model;

public class Admin {
	private long idAdmin;
	private String nome;
	private String cognome;
	
	public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
}
