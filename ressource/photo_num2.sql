drop table LesClients cascade constraints;
drop table LesAdresses cascade constraints;
drop table LesCommandes cascade constraints;
drop table LesImpressions cascade constraints;
drop table LesArticles cascade constraints;
drop table LesCatalogues cascade constraints;
drop table LesFichiersImages cascade constraints;
drop table LesPhotos cascade constraints;
drop table LesTiragesPhotos cascade constraints;
drop table LesAlbums cascade constraints;
drop table LesCadres cascade constraints;
drop table LesCalendriers cascade constraints;
drop table LesPromotions cascade constraints;
drop table LesPages cascade constraints;
drop table LesStocks cascade constraints;

create table LesClients(
        id_client number,
        adr_mail varchar2(25),
        nom varchar2(20),
        prenom varchar2(20),
        mot_de_passe varchar2(20),
        constraint LesClients_PK primary key (id_client)
);

create table LesAdresses(
        id_client number,
        num_rue number,
        nom_rue varchar2(25),
        ville varchar2(20),
        code_postal number,
        constraint LesAdresses_PK primary key (id_client),
        constraint LesAdresses_FK foreign key (id_client) REFERENCES LesClients(id_client)
);


create table LesCommandes (
        id_commande number,
        date_commande date,
        prix_total float,
        statut varchar2(20),
        id_client number,
        constraint LesCommandes_C1 check ( statut in ('En cours', 'Pret a l''envoi', 'Envoyee') ),
        constraint LesCommandes_PK primary key (id_commande),
        constraint LesCommandes_FK foreign key (id_client) REFERENCES LesClients(id_client)
);

create table LesCatalogues(
        support varchar2(10),
        reference varchar2(20),
        prix number,
        constraint LesCatalogues_PK primary key (reference),
        constraint LesCatalogues_C1 check (support in ('papier','calendrier','album','cadre'))
);

create table LesImpressions(
        id_impression number,
        id_client number,
        constraint LesImpressions_PK primary key (id_impression),
        constraint LesImpressions_FK foreign key (id_client) REFERENCES LesClients(id_client)
);


create table LesArticles (
        id_impression number,
        prix_impression number,
        quantite number,
        id_commande number,
        constraint LesArticles_PK primary key (id_impression),
        constraint LesArticles_FK1 foreign key (id_impression) REFERENCES LesImpressions(id_impression),
        constraint LesArticles_FK2 foreign key (id_commande) REFERENCES LesCommandes(id_commande)
);



create table LesFichiersImages(
        id_client number,
        chemin_acces varchar2(20),
        date_creation date,
        info_prise_vue varchar2(20),
        resolution_img number(6) not null,
        est_partage  number(1) not NULL check  (est_partage in (0,1)),
        constraint LesFichiersImages_PK primary key (chemin_acces),
        constraint LesFichiersImages_FK foreign key (id_client) REFERENCES LesClients(id_client)
);

create table LesPages (
        id_page number,
        id_impression number,
        no_LesPages number,
        mise_en_forme varchar2(20),
        titre varchar2(15),
        constraint LesPages_PK primary key (id_page),
        constraint LesPages_FK foreign key (id_impression) REFERENCES LesImpressions(id_impression)
);


create table LesPhotos(
        id_photo number,
        id_page number, 
        chemin_acces varchar2(20),
        parametres varchar2(20),
        text_descriptif varchar2(30),
        constraint LesPhotos_PK primary key (id_photo),
        constraint LesPhotos_FK1 foreign key (id_page) REFERENCES LesPages(id_page), 
        constraint LesPhotos_FK2 foreign key (chemin_acces) REFERENCES LesFichiersImages(chemin_acces)
);

create table LesTiragesPhotos(
        id_impression number,
        reference varchar2(20),
        cheminAcces varchar2(20),
        parametres varchar2(20),
        nb_exemplaire number,
        constraint LesTiragesPhotos_PK primary key (id_impression),
        constraint LesTiragesPhotos_FK1 foreign key (reference) REFERENCES LesCatalogues(reference)
);

create table LesAlbums (
        id_impression number,
        reference varchar2(20),
        titre varchar2(20),
        LesPhotos_couverture number,
        constraint LesAlbums_PK primary key (id_impression),
        constraint LesAlbums_FK1 foreign key (reference) REFERENCES LesCatalogues(reference),
        constraint LesAlbums_FK2 foreign key (id_impression) REFERENCES LesImpressions(id_impression),
        constraint LesAlbums_FK3 foreign key (LesPhotos_couverture) REFERENCES LesPhotos(id_photo)
);

create table LesCadres(
        id_impression number,
        reference varchar2(20), 
        constraint LesCadres_PK primary key (id_impression),
        constraint LesCadres_FK1 foreign key (id_impression) REFERENCES LesImpressions(id_impression),
        constraint LesCadres_FK2 foreign key (reference) REFERENCES LesCatalogues(reference)    
);

create table LesCalendriers (
        id_impression number,
        reference varchar2(20),
        constraint LesCalendriers_PK primary key (id_impression),
        constraint LesCalendriers_FK1 foreign key (id_impression) REFERENCES LesImpressions(id_impression),
        constraint LesCalendriers_FK2 foreign key (reference) REFERENCES LesCatalogues(reference)
);

create table LesPromotions (
        code_promo varchar2(20),
        reduction number(2),
        id_commande number,
        constraint LesPromotions_FK foreign key (id_commande) REFERENCES LesCommandes(id_commande)
);



 
create table LesStocks(
        reference varchar2(20),
        quantite number,
        constraint LesStocks_FK foreign key (reference)  REFERENCES LesCatalogues(reference)
);
