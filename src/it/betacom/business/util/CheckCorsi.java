package it.betacom.business.util;

import it.betacom.business.model.Corso;
import it.betacom.business.model.CorsoCorsista;

public class CheckCorsi {

	public static boolean checkCorsi(CorsoCorsista[] cc, long corsoId) {
		for(CorsoCorsista coco : cc) {
			if(coco.getIdCorso() == corsoId)
				return false;
		}
		return true;
	}
	
	public static boolean checkDisponibilita(CorsoCorsista[] cc) {
		return false;
	}
}
