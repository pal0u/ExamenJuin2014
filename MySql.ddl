-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 9.1.6              
-- * Generator date: Feb 25 2013              
-- * Generation date: Wed Jun 04 09:06:47 2014 
-- * LUN file: C:\Users\Nico\Desktop\Projet JUIN 2014\ProjetFoot\projetFootJuin2014 FINAL.lun 
-- * Schema: mpd foot/1-1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database mpd foot;
use mpd foot;


-- Tables Section
-- _____________ 

create table Arbitre (
     idArbitre int not null,
     Licence int not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     constraint ID_Arbitre_ID primary key (idArbitre));

create table Blessures (
     idBles int not null,
     NumeroDAffiliation int not null,
     Blessure char(50) not null,
     Duree date not null,
     idMatch char(1) not null,
     constraint ID_Blessures_ID primary key (idBles));

create table Clubs (
     idClub char(1) not null,
     idCq int not null,
     idPres int not null,
     Nom varchar(50) not null,
     Matricule int not null,
     constraint ID_Clubs_ID primary key (idClub),
     constraint FKGere_ID unique (idCq),
     constraint FKDirige_ID unique (idPres));

create table Coach (
     idCoach int not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     AnneeDActivites varchar(15) not null,
     constraint ID_Coach_ID primary key (idCoach));

create table Comporte (
     idDelegue int not null,
     idEquipe int not null,
     constraint ID_Comporte_ID primary key (idEquipe, idDelegue));

create table CorrespondantQualifie (
     idCq int not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     Telephone varchar(15) not null,
     E_mail varchar(100) not null,
     constraint ID_CorrespondantQualifie_ID primary key (idCq));

create table Dispute (
     idClub char(1) not null,
     idMatch char(1) not null,
     constraint ID_Dispute_ID primary key (idMatch, idClub));

create table Delegue (
     idDelegue int not null,
     Telephone varchar(15) not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     constraint ID_Delegue_ID primary key (idDelegue));

create table Equipes (
     idEquipe int not null,
     Serie varchar(50) not null,
     Annee int not null,
     idClub char(1) not null,
     constraint ID_Equipes_ID primary key (idEquipe));

create table est_entrainee_par (
     idCoach int not null,
     idEquipe int not null,
     constraint ID_est_entrainee_par_ID primary key (idEquipe, idCoach));

create table Joue (
     idEquipe int not null,
     idMatch char(1) not null,
     constraint ID_Joue_ID primary key (idMatch, idEquipe));

create table Joueurs (
     idJoueurs char(1) not null,
     NumeroDAffiliation int not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     DateDeNaissance date not null,
     constraint ID_Joueurs_ID primary key (idJoueurs));

create table JoueursMontants (
     idEquipe int not null,
     idJoueurs char(1) not null,
     constraint ID_JoueursMontants_ID primary key (idJoueurs, idEquipe));

create table Lieux (
     idLieux int not null,
     Adresse varchar(100) not null,
     constraint ID_Lieux_ID primary key (idLieux));

create table Matchs (
     idMatch char(1) not null,
     NumeroDeMatch int not null,
     Date date not null,
     Heure varchar(5) not null,
     Score varchar(4) not null,
     idArbitre int not null,
     idLieux int not null,
     constraint ID_Matchs_ID primary key (idMatch));

create table Participe (
     idJoueurs char(1) not null,
     idMatch char(1) not null,
     constraint ID_Participe_ID primary key (idJoueurs, idMatch));

create table President (
     idPres int not null,
     Nom varchar(50) not null,
     Prenom varchar(50) not null,
     AnneesDActivite varchar(15) not null,
     constraint ID_President_ID primary key (idPres));

create table Suspensions (
     idSus int not null,
     NumeroDAffiliation int not null,
     Nombre varchar(4) not null,
     idMatch char(1) not null,
     constraint ID_Suspensions_ID primary key (idSus));


-- Constraints Section
-- ___________________ 

-- Not implemented
-- alter table Arbitre add constraint ID_Arbitre_CHK
--     check(exists(select * from Matchs
--                  where Matchs.idArbitre = idArbitre)); 

alter table Blessures add constraint FKVictime_FK
     foreign key (idMatch)
     references Matchs (idMatch);

-- Not implemented
-- alter table Clubs add constraint ID_Clubs_CHK
--     check(exists(select * from Dispute
--                  where Dispute.idClub = idClub)); 

-- Not implemented
-- alter table Clubs add constraint ID_Clubs_CHK
--     check(exists(select * from Equipes
--                  where Equipes.idClub = idClub)); 

alter table Clubs add constraint FKGere_FK
     foreign key (idCq)
     references CorrespondantQualifie (idCq);

alter table Clubs add constraint FKDirige_FK
     foreign key (idPres)
     references President (idPres);

-- Not implemented
-- alter table Coach add constraint ID_Coach_CHK
--     check(exists(select * from est_entrainee_par
--                  where est_entrainee_par.idCoach = idCoach)); 

alter table Comporte add constraint FKCom_Equ
     foreign key (idEquipe)
     references Equipes (idEquipe);

alter table Comporte add constraint FKCom_Del_FK
     foreign key (idDelegue)
     references Delegue (idDelegue);

alter table Dispute add constraint FKDis_Mat
     foreign key (idMatch)
     references Matchs (idMatch);

alter table Dispute add constraint FKDis_Clu_FK
     foreign key (idClub)
     references Clubs (idClub);

-- Not implemented
-- alter table Delegue add constraint ID_Delegue_CHK
--     check(exists(select * from Comporte
--                  where Comporte.idDelegue = idDelegue)); 

-- Not implemented
-- alter table Equipes add constraint ID_Equipes_CHK
--     check(exists(select * from Comporte
--                  where Comporte.idEquipe = idEquipe)); 

-- Not implemented
-- alter table Equipes add constraint ID_Equipes_CHK
--     check(exists(select * from est_entrainee_par
--                  where est_entrainee_par.idEquipe = idEquipe)); 

-- Not implemented
-- alter table Equipes add constraint ID_Equipes_CHK
--     check(exists(select * from JoueursMontants
--                  where JoueursMontants.idEquipe = idEquipe)); 

-- Not implemented
-- alter table Equipes add constraint ID_Equipes_CHK
--     check(exists(select * from Joue
--                  where Joue.idEquipe = idEquipe)); 

alter table Equipes add constraint FKSe_compose_de_FK
     foreign key (idClub)
     references Clubs (idClub);

alter table est_entrainee_par add constraint FKest_Equ
     foreign key (idEquipe)
     references Equipes (idEquipe);

alter table est_entrainee_par add constraint FKest_Coa_FK
     foreign key (idCoach)
     references Coach (idCoach);

alter table Joue add constraint FKJou_Mat
     foreign key (idMatch)
     references Matchs (idMatch);

alter table Joue add constraint FKJou_Equ_1_FK
     foreign key (idEquipe)
     references Equipes (idEquipe);

-- Not implemented
-- alter table Joueurs add constraint ID_Joueurs_CHK
--     check(exists(select * from JoueursMontants
--                  where JoueursMontants.idJoueurs = idJoueurs)); 

-- Not implemented
-- alter table Joueurs add constraint ID_Joueurs_CHK
--     check(exists(select * from Participe
--                  where Participe.idJoueurs = idJoueurs)); 

alter table JoueursMontants add constraint FKJou_Jou
     foreign key (idJoueurs)
     references Joueurs (idJoueurs);

alter table JoueursMontants add constraint FKJou_Equ_FK
     foreign key (idEquipe)
     references Equipes (idEquipe);

-- Not implemented
-- alter table Lieux add constraint ID_Lieux_CHK
--     check(exists(select * from Matchs
--                  where Matchs.idLieux = idLieux)); 

-- Not implemented
-- alter table Matchs add constraint ID_Matchs_CHK
--     check(exists(select * from Dispute
--                  where Dispute.idMatch = idMatch)); 

-- Not implemented
-- alter table Matchs add constraint ID_Matchs_CHK
--     check(exists(select * from Joue
--                  where Joue.idMatch = idMatch)); 

-- Not implemented
-- alter table Matchs add constraint ID_Matchs_CHK
--     check(exists(select * from Participe
--                  where Participe.idMatch = idMatch)); 

alter table Matchs add constraint FKSiffle_par_FK
     foreign key (idArbitre)
     references Arbitre (idArbitre);

alter table Matchs add constraint FKse_deroule_FK
     foreign key (idLieux)
     references Lieux (idLieux);

alter table Participe add constraint FKPar_Mat_FK
     foreign key (idMatch)
     references Matchs (idMatch);

alter table Participe add constraint FKPar_Jou
     foreign key (idJoueurs)
     references Joueurs (idJoueurs);

alter table Suspensions add constraint FKA_recu_FK
     foreign key (idMatch)
     references Matchs (idMatch);


-- Index Section
-- _____________ 

create unique index ID_Arbitre_IND
     on Arbitre (idArbitre);

create unique index ID_Blessures_IND
     on Blessures (idBles);

create index FKVictime_IND
     on Blessures (idMatch);

create unique index ID_Clubs_IND
     on Clubs (idClub);

create unique index FKGere_IND
     on Clubs (idCq);

create unique index FKDirige_IND
     on Clubs (idPres);

create unique index ID_Coach_IND
     on Coach (idCoach);

create unique index ID_Comporte_IND
     on Comporte (idEquipe, idDelegue);

create index FKCom_Del_IND
     on Comporte (idDelegue);

create unique index ID_CorrespondantQualifie_IND
     on CorrespondantQualifie (idCq);

create unique index ID_Dispute_IND
     on Dispute (idMatch, idClub);

create index FKDis_Clu_IND
     on Dispute (idClub);

create unique index ID_Delegue_IND
     on Delegue (idDelegue);

create unique index ID_Equipes_IND
     on Equipes (idEquipe);

create index FKSe_compose_de_IND
     on Equipes (idClub);

create unique index ID_est_entrainee_par_IND
     on est_entrainee_par (idEquipe, idCoach);

create index FKest_Coa_IND
     on est_entrainee_par (idCoach);

create unique index ID_Joue_IND
     on Joue (idMatch, idEquipe);

create index FKJou_Equ_1_IND
     on Joue (idEquipe);

create unique index ID_Joueurs_IND
     on Joueurs (idJoueurs);

create unique index ID_JoueursMontants_IND
     on JoueursMontants (idJoueurs, idEquipe);

create index FKJou_Equ_IND
     on JoueursMontants (idEquipe);

create unique index ID_Lieux_IND
     on Lieux (idLieux);

create unique index ID_Matchs_IND
     on Matchs (idMatch);

create index FKSiffle_par_IND
     on Matchs (idArbitre);

create index FKse_deroule_IND
     on Matchs (idLieux);

create unique index ID_Participe_IND
     on Participe (idJoueurs, idMatch);

create index FKPar_Mat_IND
     on Participe (idMatch);

create unique index ID_President_IND
     on President (idPres);

create unique index ID_Suspensions_IND
     on Suspensions (idSus);

create index FKA_recu_IND
     on Suspensions (idMatch);

