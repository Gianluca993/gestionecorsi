package it.betacom.architecture.dao;

public interface DAOConstants {
	
	//STATS
	String TOT_CORSISTI="select count(*) from corsisti";
	String CORSISTI_PER_CORSO="\r\n"
			+ "select distinct nome_corsista, cognome_corsista from corsisti, corsi_corsisti, corsi where\r\n"
			+ "corsi_corsisti.id_corsista=corsisti.id_corsista and corsi_corsisti.id_corso=?";
	String NUMERO_COMMENTI="select count(commenti_corso) from corsi";
	String DATA_INIZIO_LASTC="select data_inizio from corsi where data_inizio=(select max(data_inizio) from corsi)";
	String DURATA_MEDIA="select avg(((data_fine-data_inizio)-((data_fine-data_inizio)/7*2))) from corsi";
	String ALL_CV="select cv_docente from docenti";
	String CV_DOCENTE="select cv_docente from docenti where id_docente=?";
	String CORSO_MAXFREQ="select * from (select nome_corso ,count(id_corsista) as conteggio from corsi_corsisti, corsi where corsi_corsisti.id_corso=corsi.id_corso group by nome_corso order by conteggio desc) where rownum <=1";
	
	String CORSI_POSTI_LIBERI="select nome_corso ,count(id_corsista) as conteggio from corsi_corsisti, corsi where corsi_corsisti.id_corso=corsi.id_corso  group by nome_corso having count(id_corsista) < 12";
	
	//INSERT
	String INSERT_DOC="insert into docenti values(?,?,?,?)";
	String INSERT_CORSO="insert into corsi values(?,?,?,?,?,?,?,?)";
	String INSERT_CORSISTA="insert into corsisti values(?,?,?,?)";
	String INSERT_CORSCORS="insert into corsi_corsisti values(?,?)";
	
	//SELECT
	String CORSISTA="select * from corsisti where id_corsista=?";
	String DOCENTE="select * from docenti where id_docente=?";
	String CORSO="select * from corsi where id_corso=?";
	String ADMIN="select * from admin where id_admin=?";
	String CORSICORSISTI_CORSOID="select * from corsi_corsisti where corso_id = ?";
	String CORSICORSISTI_CORSISTAID="select * from corsi_corsisti where corsista_id = ?";
	
	//SELECT ALL
	String DOCENTE_GETALL="select * from docenti";
	String CORSO_GETALL="select * from corsi";
	String CORSI_CORSISTI_GETALL="select * from corsi_corsisti";
	String CORSISTI_GETALL="select * from corsisti";
	
	//DELETE
	
	String DEL_DOC="delete from docenti where id_docente=?";
	String DEL_CORSISTA="delete from corsisti where id_corsista=?";
	String DEL_CORSO="delete from corsi where id_corso=?";
	
	//UPDATE
	
	String UPD_DOC="update docenti set nome_docente=?, cognome_docente=?, cv_docente=? where id_docente=? ";
	String UPD_CORSISTA="update corsisti set nome_corsista=?, cognome_corsista=?, precedenti_formativi=? where id_corsista=?";
	String UPD_CORSO="update corsi set nome_corso=?, data_inizio=?, data_fine=?, costo=?, commenti_corso=?, aula_corso=?, id_docente=? where id_corso=?";
	
	//LOGIN
	String GET_ADMINID="select admin_id from admin where cognome = ?";	
	
	//SEQ GEN
	
	String DOC_NEXTVAL="select docenti_seq.nextval from dual";
	String ADMIN_NEXTVAL="select admin_seq.nextval from dual";
	String CORSI_NEXTVAL="select corsi_seq.nextval from dual";
	String CORSISTI_NEXTVAL="select corsisti_seq.nextval from dual";
}
