--LesClients(_IDclient, email, nom, prenom, mdp);


INSERT INTO LesClients VALUES (1, 'pierre@uga.fr', 'CHEVALLIER', 'Pierre', 'pierre');

--LesAdresses(_noRue, _nomRue, _ville, _CodePostal, IDclient);


INSERT INTO LesAdresses VALUES (16, 'Rue Gustave Eiffel', 'Paris', '91130', 1);


--LesCommandes(_IDcommande, IDclient, DateCommande, prixTOTAL, statut);

INSERT INTO LesCommandes VALUES (1, 1, TO_DATE('01-03-2021','DD-MM-YYYY'), 9, 'Envoyee');
INSERT INTO LesCommandes VALUES (3, 1, TO_DATE('01-03-2021','DD-MM-YYYY'), 13.6,'En cours');



--LesCatalogues(_refrce, support, prix);

INSERT INTO LesCatalogues VALUES ('30x20BOIS', 'cadre', 2.5);
INSERT INTO LesCatalogues VALUES ('45x30BOIS', 'cadre', 3.6);
INSERT INTO LesCatalogues VALUES ('60x40BOIS', 'cadre', 3.9);
INSERT INTO LesCatalogues VALUES ('75x50BOIS', 'cadre', 4.9);
INSERT INTO LesCatalogues VALUES ('60x20BOIS', 'cadre', 5.9);
INSERT INTO LesCatalogues VALUES ('90x30BOIS', 'cadre', 6.5);
INSERT INTO LesCatalogues VALUES ('20x20BOIS', 'cadre', 2.99);
INSERT INTO LesCatalogues VALUES ('30x30BOIS', 'cadre', 3.99);
INSERT INTO LesCatalogues VALUES ('40x40BOIS', 'cadre', 4.99);
INSERT INTO LesCatalogues VALUES ('50x50BOIS', 'cadre', 5.99);
INSERT INTO LesCatalogues VALUES ('30x20METAL', 'cadre', 2.5);
INSERT INTO LesCatalogues VALUES ('45x30METAL', 'cadre', 3.6);
INSERT INTO LesCatalogues VALUES ('60x40METAL', 'cadre', 3.9);
INSERT INTO LesCatalogues VALUES ('75x50METAL', 'cadre', 4.9);
INSERT INTO LesCatalogues VALUES ('60x20METAL', 'cadre', 5.9);
INSERT INTO LesCatalogues VALUES ('90x30METAL', 'cadre', 6.5);
INSERT INTO LesCatalogues VALUES ('20x20METAL', 'cadre', 2.99);
INSERT INTO LesCatalogues VALUES ('30x30METAL', 'cadre', 3.99);
INSERT INTO LesCatalogues VALUES ('40x40METAL', 'cadre', 4.99);
INSERT INTO LesCatalogues VALUES ('50x50METAL', 'cadre', 5.99);
INSERT INTO LesCatalogues VALUES ('84x60MAT', 'papier', 5.9);
INSERT INTO LesCatalogues VALUES ('60x42MAT', 'papier', 3.6);
INSERT INTO LesCatalogues VALUES ('42x30MAT', 'papier', 3.9);
INSERT INTO LesCatalogues VALUES ('30x21MAT', 'papier', 4.9);
INSERT INTO LesCatalogues VALUES ('21x15MAT', 'papier', 5.9);
INSERT INTO LesCatalogues VALUES ('84x60GLAS', 'papier', 6.5);
INSERT INTO LesCatalogues VALUES ('60x42GLAS', 'papier', 2.99);
INSERT INTO LesCatalogues VALUES ('42x30GLAS', 'papier', 3.99);
INSERT INTO LesCatalogues VALUES ('30x21GLAS', 'papier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x15GLAS', 'papier', 5.99);
INSERT INTO LesCatalogues VALUES ('84x60POCH', 'calendrier', 6.5);
INSERT INTO LesCatalogues VALUES ('60x42POCH', 'calendrier', 2.99);
INSERT INTO LesCatalogues VALUES ('42x30POCH', 'calendrier', 3.99);
INSERT INTO LesCatalogues VALUES ('30x21POCH', 'calendrier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x15POCH', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES ('84x60PLAN', 'calendrier', 5.9);
INSERT INTO LesCatalogues VALUES ('60x42PLAN', 'calendrier', 3.6);
INSERT INTO LesCatalogues VALUES ('42x30PLAN', 'calendrier', 3.99);
INSERT INTO LesCatalogues VALUES ('30x21PLAN', 'calendrier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x15PLAN', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES ('21x30ALB', 'album', 8.5);
INSERT INTO LesCatalogues VALUES ('15x21ALB', 'album', 10);
INSERT INTO LesCatalogues VALUES ('21x21ALB', 'album', 12);
INSERT INTO LesCatalogues VALUES ('30x30ALB', 'album', 15);


--LesArticles(_IDImpress, IDCommande, refrce, quantite, prixTOTAL);


INSERT INTO LesArticles VALUES (1, 1, '30x20BOIS', 1, 2.5);
INSERT INTO LesArticles VALUES (2, 1, '15x21ALB', 1, 6.5);
INSERT INTO LesArticles VALUES (3, 3, '15x21ALB', 1, 10);
INSERT INTO LesArticles VALUES (4, 3, '45x30BOIS', 1, 3.6);


--LesFichiersImages(_CheminAcces, IDclient, DateCreation, InfoPriseVue, Resolution, estPartage);

INSERT INTO LesFichiersImages VALUES('img/chien.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',20000,1);
INSERT INTO LesFichiersImages VALUES('img/ciel.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',30000,1);
INSERT INTO LesFichiersImages VALUES('img/soleil.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',40000,1);
INSERT INTO LesFichiersImages VALUES('img/ann2020.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',50000,0);
INSERT INTO LesFichiersImages VALUES('img/world.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',35000,0);
INSERT INTO LesFichiersImages VALUES('img/chat.png',1,TO_DATE('01-03-2021','DD-MM-YYYY'),'<info>',70000,1);



--LesAlbums(IDimpress, refrce, titre, couverture);

INSERT INTO LesAlbums VALUES (1, '15x21ALB', 'Bonjour', 5);


--LesCadres(IDimpress, refrce);

INSERT INTO LesCadres VALUES (3, '30x20BOIS');
INSERT INTO LesCadres VALUES (2, '90x30BOIS');
INSERT INTO LesCadres VALUES (4, '45x30BOIS');


--LesCalendries(_IDcalendrier,IDimpress, refrce);


--LesImpressions(_IDimpress, IDclient);

INSERT INTO LesImpressions VALUES (1, 1);
INSERT INTO LesImpressions VALUES (2, 1);
INSERT INTO LesImpressions VALUES (3, 1);
INSERT INTO LesImpressions VALUES (4, 1);



--LesPages(idPage, idImpression noPage, MiseEnForme , titre);

INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(11,1,1,"<nth>","mes vacances"); 
INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(12,1,2,"<nth>","mes vacances 2");
INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(13,1,3,"<nth>","souvenirs");
INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(21,2,1,"<nth>","mes vacances");
INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(31,3,1,"<nth>","mes vacances 2");
INSERT INTO LesPages(idPage,IDimpress,noPage,mise_en_forme,titre) VALUES(41,4,1,"<nth>","souvenirs");


--LesPhotos(idPage, CheminAcces, parametres, textDescrip);

INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (11,'img/chien.png');
INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (11, 'img/ciel.png', 'Photo du ciel');
INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (12, 'img/soleil.png', 'augmenter luminosite');
INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (13, 'img/ann2020.png', 'annee 2020');
INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (21, 'img/world.png', 'diminuer contraste');
INSERT INTO LesPhotos(idPage, CheminAcces, textDescrip) VALUES (31, 'img/chat.png', 'diminuer contraste');

--LesStocks(_refrce, quantite)

INSERT INTO LesStocks VALUES('30x20BOIS', 3);
INSERT INTO LesStocks VALUES('45x30BOIS', 11);
INSERT INTO LesStocks VALUES('60x40BOIS', 12);
INSERT INTO LesStocks VALUES('75x50BOIS', 17);
INSERT INTO LesStocks VALUES('60x20BOIS', 5);
INSERT INTO LesStocks VALUES('90x30BOIS', 11);
INSERT INTO LesStocks VALUES('20x20BOIS', 17);
INSERT INTO LesStocks VALUES('30x30BOIS', 30);
INSERT INTO LesStocks VALUES('40x40BOIS', 13);
INSERT INTO LesStocks VALUES('50x50BOIS', 25);
INSERT INTO LesStocks VALUES('30x20METAL', 21);
INSERT INTO LesStocks VALUES('45x30METAL', 17);
INSERT INTO LesStocks VALUES('60x40METAL', 28);
INSERT INTO LesStocks VALUES('75x50METAL', 23);
INSERT INTO LesStocks VALUES('60x20METAL', 16);
INSERT INTO LesStocks VALUES('90x30METAL', 21);
INSERT INTO LesStocks VALUES('20x20METAL', 4);
INSERT INTO LesStocks VALUES('30x30METAL', 24);
INSERT INTO LesStocks VALUES('40x40METAL', 0);
INSERT INTO LesStocks VALUES('50x50METAL', 60);
INSERT INTO LesStocks VALUES('84x60MAT', 20);
INSERT INTO LesStocks VALUES('60x42MAT', 24);
INSERT INTO LesStocks VALUES('42x30MAT', 33);
INSERT INTO LesStocks VALUES('30x21MAT', 35);
INSERT INTO LesStocks VALUES('21x15MAT', 60);
INSERT INTO LesStocks VALUES('84x60GLAS', 62);
INSERT INTO LesStocks VALUES('60x42GLAS', 20);
INSERT INTO LesStocks VALUES('42x30GLAS', 5);
INSERT INTO LesStocks VALUES('30x21GLAS', 4);
INSERT INTO LesStocks VALUES('21x15GLAS', 3);
INSERT INTO LesStocks VALUES('84x60POCH', 8);
INSERT INTO LesStocks VALUES('60x42POCH', 56);
INSERT INTO LesStocks VALUES('42x30POCH', 24);
INSERT INTO LesStocks VALUES('30x21POCH', 30);
INSERT INTO LesStocks VALUES('21x15POCH', 31);
INSERT INTO LesStocks VALUES('84x60PLAN', 55);
INSERT INTO LesStocks VALUES('60x42PLAN', 6);
INSERT INTO LesStocks VALUES('42x30PLAN', 2);
INSERT INTO LesStocks VALUES('30x21PLAN', 0);
INSERT INTO LesStocks VALUES('21x15PLAN', 1);
INSERT INTO LesStocks VALUES('21x30ALB', 1);
INSERT INTO LesStocks VALUES('15x21ALB', 2);
INSERT INTO LesStocks VALUES('21x21ALB', 6);
INSERT INTO LesStocks VALUES('30x30ALB', 3);
