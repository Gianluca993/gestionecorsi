package it.betacom.business.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import it.betacom.business.model.Docente;

public class CVReader {

	
	public static Docente countCV(Docente[] docenti) throws IOException {
		int counterDoc = 0;
		int counter = 0;
		Docente doc = null;
		FileReader fr;
		BufferedReader br;
		for(Docente d: docenti) {
			File file = new File(d.getCvDocente());
			if(file.exists()) {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String riga;
			counter = 0;
			while((riga=br.readLine())!=null) {  
				counter++;
				}
			if(counter > counterDoc) {
				counterDoc = counter;
				doc = d;
			}
			br.close();
			fr.close();
			}
		}
		return doc;
	}
}
