drop table admin cascade constraints;
drop table docenti cascade constraints;
drop table corsi cascade constraints;
drop table corsisti cascade constraints;
drop table corsi_corsisti cascade constraints;

create table admin (
	id_admin int,
	nome_admin varchar2(30),
	cognome_admin varchar2(30),
	constraint p_idadm primary key (id_admin)
);

create table docenti (
	id_docente int,
	nome_docente varchar2(30),
	cognome_docente varchar2(30),
	cv_docente varchar(200),
	constraint p_iddocente primary key (id_docente)
);

create table corsi (
	id_corso int,
	nome_corso varchar2(30),
	data_inizio date,
	data_fine date,
	costo number(7,2),
	commenti_corso varchar(200),
	aula_corso number(2),
	id_docente int,
	constraint p_idcorso primary key (id_corso),
	constraint f_iddoc foreign key (id_docente) references docenti(id_docente)
);

create table corsisti (
	id_corsista int,
	nome_corsista varchar2(30),
	cognome_corsista varchar2(30),
	precedenti_formativi number(1),
	constraint chk_prec check (precedenti_formativi >= 0 and precedenti_formativi <= 1),
	constraint p_idcors primary key (id_corsista)
);

create table corsi_corsisti (
	id_corso int,
	id_corsista int,
	constraint f_idcorso foreign key (id_corso) references corsi(id_corso),
	constraint f_idcors foreign key (id_corsista) references corsisti(id_corsista)
);

create sequence admin_seq;
create sequence corsi_seq;
create sequence corsisti_seq;
create sequence docenti_seq;

