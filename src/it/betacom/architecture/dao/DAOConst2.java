package it.betacom.architecture.dao;

public interface DAOConst2 {
	String TOT_CORSISTI="select count(*) from corsisti";
	String CORSISTI_PER_CORSO="\r\n"
			+ "select distinct nome_corsista, cognome_corsista from corsisti, corsi_corsisti, corsi where\r\n"
			+ "corsi_corsisti.id_corsista=corsisti.id_corsista and corsi_corsisti.id_corso=?";
	String NUMERO_COMMENTI="select count(commenti_corso) from corsi";
	String DATA_INIZIO_LASTC="select data_inizio from corsi where data_inizio=(select max(data_inizio) from corsi)";
	String CORSISTI_GETALL="select * from corsisti";
	String DURATA_MEDIA="select avg(((data_fine-data_inizio)-((data_fine-data_inizio)/7*2))) from corsi";
}
