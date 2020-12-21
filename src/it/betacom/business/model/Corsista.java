package it.betacom.business.model;

public class Corsista {
	private long idCorsista;
	private String nomeCorsista;
	private String cognomeCorsista;
	private boolean precFormativi;
	
	public long getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(long idCorsista) {
		this.idCorsista = idCorsista;
	}
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	public boolean isPrecFormativi() {
		return precFormativi;
	}
	public void setPrecFormativi(boolean precFormativi) {
		this.precFormativi = precFormativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [idCorsista=" + idCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precFormativi=" + precFormativi + "]";
	}
	
	
	
}
