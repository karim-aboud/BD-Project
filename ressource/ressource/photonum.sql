create table Client ( 

id_client number 

adr_mail varchar2(25), 

nom varchar2(20), 

prenom varchar2(20), 

mot_de_passe varchar2(20), 

constraint Client_PK primary key (id_client) 

  

); 

  

create table Adresse ( 

id_client number, 

num_rue number 

nom_rue varchar2(25), 

ville varchar2(20), 

code_postal number, 

constraint Adresse_PK primary key (id_client) 

); 

create table Commande ( 

id_commande number, 

date_commande date, 

prix_total float 

statut varchar2(15), 

id_client number, 

constraint Commande_C1 check ( statut in ('En Cours', 'Pret a l\'envoi', 'Envoyee') ), 

constraint Commande_PK primary key (id_commande), 

constraint Commande_FK foreign key (id_client) REFERENCES Client(id_client) 

); 

  

  

create table Impression( 

id_impression number, 

id_client number, 

constraint Impression_PK primary key (id_impression), 

constraint Impression_FK foreign key (id_client) REFERENCES Client(id_client) 

); 

  

  

create table Article ( 

id_impression number, 

prix_impression number, 

quantite number, 

id_commande number, 

constraint Article_PK primary key (id_impression), 

constraint Article_FK1 foreign key (id_impression) REFERENCES Impression(id_impression), 

constraint Article_FK2 foreign key (id_commande) REFERENCES Commande(id_commande) 

); 

  

  

create table TiragesPhoto ( 

id_impression number, 

reference number, 

cheminAcces varchar2(20), 

parametres varchar2(20), 

nb_exemplaire number 

constraint TiragesPhoto_PK primary key (id_impression), 

constraint TiragesPhoto_FK1 foreign key (reference) REFERENCES Catalogue(reference) 

  

); 

  

create table Albums ( 

id_impression number, 

reference number, 

titre varchar2(20), 

photo_couverture number, 

constraint Albums_PK primary key (id_impression), 

constraint Albums_FK1 foreign key (reference) REFERENCES Catalogue(reference), 

constraint Albums_FK2 foreign key (id_impression) REFERENCES Impression(id_impression), 

constraint Albums_FK3 foreign key (photo_couverture) REFERENCES Photo(id_photo) 

); 

  

create table Cadres ( 

id_impression number, 

reference number,  

constraint Cadres_PK primary key (id_impression), 

constraint Cadres_FK1 foreign key (id_impression) REFERENCES Impression(id_impression), 

constraint Cadres_FK2 foreign key (reference) REFERENCES Catalogue(reference) 

); 

  

create table Calendriers ( 

id_impression number, 

reference number, 

constraint Calendriers_PK primary key (id_impression), 

constraint Calendriers_FK1 foreign key (id_impression) REFERENCES Impression(id_impression), 

constraint Calendriers_FK2 foreign key (reference) REFERENCES Catalogue(reference) 

); 

  

create table Promotion ( 

code_promo varchar2(20), 

reduction number(2), 

id_commande number, 

constraint Promotion_FK foreign key (id_commande) REFERENCES Commande(id_commande) 

); 

  

create table FichierImage ( 

id_client number 

chemin_acces varchar2(20), 

info_prise_vue varchar2(20),  

resolution_img number(6) not null, 

est_partage  number(1) not NULL check  (est_partage in (0,1)), 

  constraint FichierImage_PK primary key (chemin_acces), 

  constraint FichierImage_FK foreign key (id_client) REFERENCES Client(id_client) 

); 

  

create table Photo ( 

id_photo number, 

id_page number,  /* c'est bien une foreign key et non pas un primary key comme on avait ecrit car on a plusieur photos dans 1 meme page */ 

parametres varchar2(20), 

text_descriptif varchar2(25), 

constraint Photo_PK primary key (id_photo), 

constraint Photo_FK1 foreign key (id_page) REFERENCES Page(id_page),  

constraint Photo_FK2 foreign key (chemin_acces) REFERENCES FichierImage(chemin_access) 

  

); 

  

  

create table Page ( 

id_page number, 

id_impression number, 

no_page number, 

mise_en_forme varchar2(20), 

titre varchar2(15), 

constraint Page_PK primary key (id_page), 

constraint Page_FK foreign key (id_impression) REFERENCES Impression(id_impression) 

); 

  

create table Catalogue ( 
support varchar2(10), 

reference varchar2(10), 

prix number, 

constraint Catalogue_PK primary key (support,reference), 

constraint Catalogue_C1 check (support in ('papier','calendrier','album','cadre')) 

); 

  

  

create table Stocks ( 

support varchar2(10), 

reference varchar2(10), 

quantite number, 

constraint Stocks_FK foreign key (support,reference)  REFERENCES Catalogue(support,reference) 

); 
