package it.betacom.business.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import it.betacom.business.model.LoginData;

public class CountLogin {

	HttpServletRequest request;
	ServletContext context;
	
	public CountLogin(HttpServletRequest request) {
		this.request = request;
		this.context = request.getServletContext();
		count();
	}
	
	private void count() {
		LoginData lastTry = (LoginData) context.getAttribute(request.getRemoteAddr());
		if(lastTry == null)
			context.setAttribute(request.getRemoteAddr(), new LoginData(request.getRemoteAddr(), 1, new Date()));
		else if (lastTry.getCount() < 5) {
			lastTry.increaseCount();
			context.setAttribute(request.getRemoteAddr(), lastTry);
		} else {
			if(confrontaDate(lastTry)) {
				context.removeAttribute(request.getRemoteAddr());
			}
		}
	}
	
	private boolean confrontaDate(LoginData lastTry) {
		LocalDateTime data = LocalDateTime.ofInstant(lastTry.getDate().toInstant(), ZoneId.systemDefault());
		LocalDateTime now = LocalDateTime.now();
		if(data.plusMinutes(5).compareTo(now) <= 0)
			return true;
		return false;
	}
}
