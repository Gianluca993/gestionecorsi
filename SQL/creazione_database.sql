drop table admin cascade constraints;
drop table docenti cascade constraints;
drop table corsi cascade constraints;
drop table corsisti cascade constraints;
drop table corsi_corsisti cascade constraints;

drop sequence admin_seq
drop sequence docenti_seq
drop sequence corsi_seq
drop sequence corsisti_seq

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
	cv_docente varchar(100),
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
	constraint f_idcorso foreign key (id_corso) references corsi(id_corso) on delete cascade,
	constraint f_idcors foreign key (id_corsista) references corsisti(id_corsista) on delete cascade
);

create sequence admin_seq;
create sequence corsi_seq;
create sequence corsisti_seq;
create sequence docenti_seq;




insert into docenti values(1,'Gino','Peppino','ginpeppurl');
insert into docenti values(2,'Nonno','Nanni','nonnonaurl');
insert into docenti values(3,'Maggio','For','forurl');
insert into docenti values(4,'Ben','Zina','benurl');

insert into corsi values(1,'JAVA','20-FEB-2020','21-MAR-2020', 127.00,'java corso',1,1);
insert into corsi values(2,'GOLANG','22-MAR-2020','23-MAG-2020', 200.00,'golang corso',1,1);
insert into corsi values(3,'RUBY','20-FEB-2020','22-APR-2020', 100.00,'ruby corso',2,2);
insert into corsi values(4,'PYTHON','12-GEN-2020','14-MAR-2020', 127.00,'python corso',3,4);
insert into corsi values(5,'ARCHLINUX','23-LUG-2020','21-SET-2020', 300.00,'archlinux corso',5,3);
insert into corsi values(6,'DOCKER','1-OTT-2020','21-DIC-2020', 220.00,'docker corso',6,3);
insert into corsi values(7,'NMAP','12-GEN-2020','21-MAR-2020', 128.00,'nmap corso',7,2);
insert into corsi values(8,'BASHSCRIPT','2-AGO-2020','21-SET-2020', 90.00,'bash corso',3,3);

insert into corsisti values(1,'Bruno','Munari',0);
insert into corsisti values(2,'Tiziano','Sacci',0);
insert into corsisti values(3,'Bubbolo','Bubbo',0);
insert into corsisti values(4,'Simone','Puzzi',0);
insert into corsisti values(5,'Cino','Libri',0);
insert into corsisti values(6,'Tino','Bisco',0);


insert into corsi_corsisti values(1,1);
insert into corsi_corsisti values(2,1);
insert into corsi_corsisti values(3,2);
insert into corsi_corsisti values(4,1);
insert into corsi_corsisti values(5,1);
insert into corsi_corsisti values(6,3);
insert into corsi_corsisti values(7,4);
insert into corsi_corsisti values(8,1);
insert into corsi_corsisti values(1,2);
insert into corsi_corsisti values(8,2);
insert into corsi_corsisti values(3,1);
insert into corsi_corsisti values(1,6);
insert into corsi_corsisti values(6,1);
insert into corsi_corsisti values(5,6);
insert into corsi_corsisti values(5,3);
insert into corsi_corsisti values(5,1);