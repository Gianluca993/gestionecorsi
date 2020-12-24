package it.betacom.business.model;

import java.io.Serializable;
import java.util.Date;

public class LoginData implements Serializable {
	private static final long serialVersionUID = -5439806449629117609L;

	String ip;
	int count;
	Date date;
	
	public LoginData() {
		
	}
	
	public LoginData(String ip, int count, Date date) {
		this.ip = ip;
		this.count = count;
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void increaseCount() {
		if(count < 5)
			this.count++;
	}
}
