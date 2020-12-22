package it.betacom.business.model;

import java.util.Date;

public class Corso {
	private long idCorso;
	private String nomeCorso;
	private Date dataInizio;
	private Date dataFine;
	private double costo;
	private String commentiCorso;
	private int aulaCorso;
	private long idDocente;
	
	public long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getCommentiCorso() {
		return commentiCorso;
	}
	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}
	public int getAulaCorso() {
		return aulaCorso;
	}
	public void setAulaCorso(int aulaCorso) {
		this.aulaCorso = aulaCorso;
	}
	public long getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(long idDocente) {
		this.idDocente = idDocente;
	}
	@Override
	public String toString() {
		return "Corso [idCorso=" + idCorso + ", nomeCorso=" + nomeCorso + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", costo=" + costo + ", commentiCorso=" + commentiCorso + ", aulaCorso=" + aulaCorso
				+ ", idDocente=" + idDocente + "]";
	}
	
	
	
	
}
