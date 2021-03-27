DROP TABLE LesClients CASCADE CONSTRAINT;
DROP TABLE LesAdresses CASCADE CONSTRAINT;
DROP TABLE LesCommandes CASCADE CONSTRAINT;
DROP TABLE LesImpressions CASCADE CONSTRAINT;
DROP TABLE LesArticles CASCADE CONSTRAINT;
DROP TABLE LesCatalogues CASCADE CONSTRAINT;
DROP TABLE LesFichiersImages CASCADE CONSTRAINT;
DROP TABLE LesPhotos CASCADE CONSTRAINT;
DROP TABLE LesTiragesPhotos CASCADE CONSTRAINT;
DROP TABLE LesAlbums CASCADE CONSTRAINT;
DROP TABLE LesCadres CASCADE CONSTRAINT;
DROP TABLE LesCalendriers CASCADE CONSTRAINT;
DROP TABLE LesPromotions CASCADE CONSTRAINT;
DROP TABLE LesPages CASCADE CONSTRAINT;
DROP TABLE LesStocks CASCADE CONSTRAINT;

--LesClients(_IDclient, email, nom, prenom, mdp);
CREATE TABLE LesClients(
	IDclient NUMBER,
	email VARCHAR2(25),
	nom VARCHAR2(20),
	prenom VARCHAR(20),
	mdp VARCHAR2(20),
	CONSTRAINT cli_pk PRIMARY KEY (IDclient)
);

--LesAdresses(noRue, nomRue, ville, CodePostal, IDclient);
CREATE TABLE LesAdresses(
	IDadresse NUMBER,
	noRue NUMBER,
	nomRue VARCHAR2(25),
	ville VARCHAR2(20),
	CodePostal NUMBER,
	IDclient NUMBER,
	CONSTRAINT adr_pk PRIMARY KEY (IDadresse),
	CONSTRAINT adr_fk FOREIGN KEY (IDclient) REFERENCES LesClients(IDclient)	
);

--LesCommandes(_IDcommande, IDclient, DateCommande, prixTOTAL, statut);
CREATE TABLE LesCommandes (
	IDcommande NUMBER,
	IDclient NUMBER,
	DateCommande DATE,
	prixTOTAL FLOAT,
	statut VARCHAR2(20),
	CONSTRAINT commd_pk PRIMARY KEY (IDcommande),
	CONSTRAINT commd_ck check ( statut in ('En cours', 'Pret a l''envoi', 'Envoyee') ),
	CONSTRAINT commd_fk FOREIGN KEY (IDclient) REFERENCES LesClients(IDclient)
);

--LesImpressions(_IDimpress, IDclient);
CREATE TABLE LesImpressions(
	IDimpress NUMBER,
	IDclient NUMBER,
	CONSTRAINT imp_pk PRIMARY KEY (IDimpress),
	CONSTRAINT imp_fk FOREIGN KEY (IDclient) REFERENCES LesClients(IDclient)
);

--LesArticles(_IDImpress, IDcommande, refrce, quantite, prix);
CREATE TABLE LesArticles (
	IDimpress NUMBER,
	IDcommande NUMBER NOT NULL,
	refrce VARCHAR2(20),
	quantite NUMBER,
	prix NUMBER,
	CONSTRAINT ar_pk PRIMARY KEY (IDimpress),
	CONSTRAINT ar_fk1 FOREIGN KEY (IDimpress) REFERENCES LesImpressions(IDimpress),
	CONSTRAINT ar_fk2 FOREIGN KEY (IDcommande) REFERENCES LesCommandes(IDcommande)
);

--LesCatalogues(_refrce, support, prix);
CREATE TABLE LesCatalogues(
	refrce VARCHAR2(20),
	support VARCHAR2(10),
	prix NUMBER,
	CONSTRAINT cat_pk PRIMARY KEY (refrce),
	CONSTRAINT cat_ck CHECK (support in ('papier','calendrier','album','cadre'))
);

--LesFichiersImages(_CheminAcces, IDclient, DateCreation, InfoPriseVue, Resolution, estPartage);
CREATE TABLE LesFichiersImages(
	CheminAcces VARCHAR2(20),
	IDclient NUMBER,
	DateCreation DATE,
	InfoPriseVue VARCHAR2(20),	
	Resolution NUMBER(6) NOT NULL,
	estPartage  NUMBER(1) NOT NULL,
  	CONSTRAINT fimg_pk PRIMARY KEY (CheminAcces),
	CONSTRAINT fimg_ck CHECK (estPartage in (0,1)),
  	CONSTRAINT fimg_fk FOREIGN KEY (IDclient) REFERENCES LesClients(IDclient)
);

--LesTiragesPhotos(_IDimpress, refrce, CheminAcces, parametres, nbExemplaire);
CREATE TABLE LesTiragesPhotos(
	IDimpress NUMBER,
	refrce VARCHAR2(20),
	CheminAcces VARCHAR2(20),
	parametres VARCHAR2(20),
	nbExemplaire NUMBER,
	CONSTRAINT tirpho_pk PRIMARY KEY (IDimpress),
	CONSTRAINT tirpho_fk FOREIGN KEY (refrce) REFERENCES LesCatalogues(refrce),
	CONSTRAINT tirpho_fk2 FOREIGN KEY (CheminAcces) REFERENCES LesFichiersImages(CheminAcces) 
);

--LesPhotos(_IDpage, CheminAcces, parametres, textDescrip, noPage);
CREATE TABLE LesPhotos(
	IDphoto NUMBER,
	IDpage NUMBER,
	CheminAcces VARCHAR2(20),
	parametres VARCHAR2(20),
	textDescrip VARCHAR2(30),
	CONSTRAINT pho_pk PRIMARY KEY (IDphoto),
	CONSTRAINT pho_fk1 FOREIGN KEY (CheminAcces) REFERENCES LesFichiersImages(CheminAcces)
);


--LesPages(IDpage, IDimpress, noPage,MiseEnForme,titre);
CREATE TABLE LesPages (
	IDPage NUMBER,
	IDimpress NUMBER,
	noPage NUMBER,
	MiseEnForme VARCHAR2(20),
	CONSTRAINT pg_pk PRIMARY KEY (IDpage),
	CONSTRAINT pg_fk FOREIGN KEY (IDimpress) REFERENCES LesImpressions(IDimpress)
);

--LesAlbums(IDimpress, refrce, titre, couverture);
CREATE TABLE LesAlbums (
	IDimpress NUMBER NOT NULL,
	refrce VARCHAR2(20) NOT NULL,
	titre VARCHAR2(20) NOT NULL,
	couverture NUMBER NOT NULL, --IDphoto
	CONSTRAINT alb_pk PRIMARY KEY (IDimpress),
	CONSTRAINT alb_fk1 FOREIGN KEY (refrce) REFERENCES LesCatalogues(refrce),
	CONSTRAINT alb_fk2 FOREIGN KEY (IDimpress) REFERENCES LesImpressions(IDimpress),
	CONSTRAINT alb_fk3 FOREIGN KEY (couverture) REFERENCES LesPages(IDpage)
);

--LesCadres(IDimpress, refrce);
CREATE TABLE LesCadres(
	IDimpress NUMBER,
	refrce VARCHAR2(20),	
	CONSTRAINT LesCadres_PK PRIMARY KEY (IDimpress),
	CONSTRAINT LesCadres_FK1 FOREIGN KEY (IDimpress) REFERENCES LesImpressions(IDimpress),
	CONSTRAINT LesCadres_FK2 FOREIGN KEY (refrce) REFERENCES LesCatalogues(refrce)	
);

--LesCalendries(IDimpress, refrce);
CREATE TABLE LesCalendriers (
	IDimpress NUMBER,
	refrce VARCHAR2(20),
	CONSTRAINT cal_pk PRIMARY KEY (IDimpress),
	CONSTRAINT cal_fk1 FOREIGN KEY (IDimpress) REFERENCES LesImpressions(IDimpress),
	CONSTRAINT cal_fk2 FOREIGN KEY (refrce) REFERENCES LesCatalogues(refrce)
);



--LesPromotions(_codePromo, IDcommande, reduction)
CREATE TABLE LesPromotions (
	codePromo VARCHAR2(20),
	IDcommande NUMBER,
	reduction NUMBER(2),
	CONSTRAINT prom_pk PRIMARY KEY (codePromo),
	CONSTRAINT prom_fk FOREIGN KEY (IDcommande) REFERENCES LesCommandes(IDcommande)
);

--LesStocks(_refrce, quantite)
CREATE TABLE LesStocks(
	refrce VARCHAR2(20),
	quantite NUMBER,
	CONSTRAINT stck_pk PRIMARY KEY (refrce),
	CONSTRAINT stck_fk FOREIGN KEY (refrce)  REFERENCES LesCatalogues(refrce)
);	

