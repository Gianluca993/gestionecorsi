package it.betacom.architecture.dao;

public interface DAOConstants {
	String TOT_CORSISTI="select count(*) from corsisti";
	String CORSISTI_PER_CORSO="\r\n"
			+ "select distinct nome_corsista, cognome_corsista from corsisti, corsi_corsisti, corsi where\r\n"
			+ "corsi_corsisti.id_corsista=corsisti.id_corsista and corsi_corsisti.id_corso=?";
	String NUMERO_COMMENTI="select count(commenti_corso) from corsi";
	String DATA_INIZIO_LASTC="select data_inizio from corsi where data_inizio=(select max(data_inizio) from corsi)";
	String CORSISTI_GETALL="select * from corsisti";
	String DURATA_MEDIA="select avg(((data_fine-data_inizio)-((data_fine-data_inizio)/7*2))) from corsi";
	String ALL_CV="select cv_docente from docenti";
	String CV_DOCENTE="select cv_docente from docenti where id_docente=?";
	String CORSO_MAXFREQ="select * from (select nome_corso ,count(id_corsista) as conteggio from corsi_corsisti, corsi where corsi_corsisti.id_corso=corsi.id_corso group by nome_corso order by conteggio desc) where rownum <=1";
	
	 
	
	//INSERT
	String INSERT_DOC="insert into docenti values(?,?,?,?)";
	String INSERT_CORSO="insert into corsi values(?,?,?,?,?,?,?,?)";
	String INSERT_CORSISTA="insert into corsisti values(?,?,?,?)";
	String INSERT_CORSCORS="insert into corsi_corsisti values(?,?)";
	
	//SELECT
	String CORSISTA="select * from corsisti where id_corsista=?";
	String DOCENTE="select * from docenti where id_docente=?";
	String CORSO="select * from corsi where id_corso=?";
	
	//DELETE
	
	String DEL_DOC="delete from docenti where id_docente=?";
	String DEL_CORSISTA="delete from corsisti where id_corsista=?";
	String DEL_CORSO="delete from corsi where id_corso=?";
	
	//UPDATE
	
	String UPD_DOC="update docenti set nome_docente=?, cognome_docente=?, cv_docente=? where id_docente=? ";
	String UPD_CORSISTA="update corsisti set nome_corsista=?, cognome_corsista=?, precedenti_formativi=? where id_corsista=?";
	String UPD_CORSO="update corsi set nome_corso=?, data_inizio=?, data_fine=?, costo=?, commenti_corso=?, aula_corso=?, id_docente=? where id_corso=?";
	
	
}
