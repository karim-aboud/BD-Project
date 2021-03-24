--LesClients(_IDclient, email, nom, prenom, mdp);

INSERT INTO LesClients VALUES (1, 'pierre@uga.fr', 'CHEVALLIER', 'Pierre', 'pierre2');
INSERT INTO LesClients VALUES (2, 'samuel@uga.fr', 'LAURAS', 'Samuel', 'samuel');
INSERT INTO LesClients VALUES (3, 'joumana@uga.fr', 'ELDAKAR', 'Joumana', 'joumana');
INSERT INTO LesClients VALUES (4, 'karim@uga.fr', 'ABOUD', 'Karim', 'karim');
INSERT INTO LesClients VALUES (5, 'romeo@uga.fr', 'AGOSSOU', 'Romeo', 'romeo');
INSERT INTO LesClients VALUES (6, 'michel@uga.fr', 'RAFAEL', 'Michelle', '154gNo');
INSERT INTO LesClients VALUES (7, 'jammy@lol.fr', 'NOEL', 'Jammy', 'hey565');


--LesAdresses(_noRue, _nomRue, _ville, _CodePostal, IDclient);


INSERT INTO LesAdresses VALUES (16, 'Rue Gustave Eiffel', 'Paris', '91130', '1');
INSERT INTO LesAdresses VALUES (74, 'Rue Banaudon', 'Paris', '69006', '1');
INSERT INTO LesAdresses VALUES (43, 'Rue de Strasbourg', 'Clermont-Ferrand', '63000', '3');
INSERT INTO LesAdresses VALUES (46, 'Cours Jean Jaurès', 'Bordeaux', '92000', '4');
INSERT INTO LesAdresses VALUES (90, 'Avenue de Marlioz', 'Argenteuil', '95100', '5');
INSERT INTO LesAdresses VALUES (49, 'Faubourg Saint Honoré', 'Paris', '75018', '6');
INSERT INTO LesAdresses VALUES (8, 'Cours Franklin Roosevelt', 'Marseille', '13010', '7');
INSERT INTO LesAdresses VALUES (22, 'Rue Meaux', 'Grenoble', '38856', '2');


--LesCommandes(_IDcommande, IDclient, DateCommande, prixTOTAL, statut);

INSERT INTO LesCommandes VALUES (1, 2, TO_DATE('01-03-2021','DD-MM-YYYY'), 14, 'En cours');
INSERT INTO LesCommandes VALUES (2, 4, TO_DATE('01-03-2021','DD-MM-YYYY'), 13, 'Envoyee');
INSERT INTO LesCommandes VALUES (3, 5, TO_DATE('01-03-2021','DD-MM-YYYY'), 15, 'Envoyee');
INSERT INTO LesCommandes VALUES (4, 7, TO_DATE('01-03-2021','DD-MM-YYYY'), 20, 'Pret a l''envoi');
INSERT INTO LesCommandes VALUES (5, 1, TO_DATE('01-03-2021','DD-MM-YYYY'), 16, 'En cours');
INSERT INTO LesCommandes VALUES (6, 6, TO_DATE('01-03-2021','DD-MM-YYYY'), 15, 'Pret a l''envoi');
INSERT INTO LesCommandes VALUES (7, 3, TO_DATE('01-03-2021','DD-MM-YYYY'), 14.5, 'Envoyee');


--LesImpressions(_IDimpress, IDclient);

INSERT INTO LesImpressions VALUES (1, 1);
INSERT INTO LesImpressions VALUES (2, 2);
INSERT INTO LesImpressions VALUES (3, 1);


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
INSERT INTO LesCatalogues VALUES ('84.1x59.4MAT', 'papier', 5.9);
INSERT INTO LesCatalogues VALUES ('59.4x42MAT', 'papier', 3.6);
INSERT INTO LesCatalogues VALUES ('42x29.7MAT', 'papier', 3.9);
INSERT INTO LesCatalogues VALUES ('29.7x21MAT', 'papier', 4.9);
INSERT INTO LesCatalogues VALUES ('21x14.8MAT', 'papier', 5.9);
INSERT INTO LesCatalogues VALUES ('84.1x59.4GLAS', 'papier', 6.5);
INSERT INTO LesCatalogues VALUES ('59.4x42GLAS', 'papier', 2.99);
INSERT INTO LesCatalogues VALUES ('42x29.7GLAS', 'papier', 3.99);
INSERT INTO LesCatalogues VALUES ('29.7x21GLAS', 'papier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x14.8GLAS', 'papier', 5.99);
INSERT INTO LesCatalogues VALUES ('84.1x59.4POCH', 'calendrier', 6.5);
INSERT INTO LesCatalogues VALUES ('59.4x42POCH', 'calendrier', 2.99);
INSERT INTO LesCatalogues VALUES ('42x29.7POCH', 'calendrier', 3.99);
INSERT INTO LesCatalogues VALUES ('29.7x21POCH', 'calendrier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x15POCH', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES ('84.1x59.4PLAN', 'calendrier', 5.9);
INSERT INTO LesCatalogues VALUES ('59.4x42PLAN', 'calendrier', 3.6);
INSERT INTO LesCatalogues VALUES ('42x29.7PLAN', 'calendrier', 3.99);
INSERT INTO LesCatalogues VALUES ('29.7x21PLAN', 'calendrier', 4.99);
INSERT INTO LesCatalogues VALUES ('21x15PLAN', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES ('21X29,7ALB', 'album', 8.5);
INSERT INTO LesCatalogues VALUES ('15X21ALB', 'album', 10);
INSERT INTO LesCatalogues VALUES ('21X21ALB', 'album', 12);
INSERT INTO LesCatalogues VALUES ('30X30ALB', 'album', 15);


--LesArticles(_IDImpress, IDCommande, refrce, quantite, prixTOTAL);


INSERT INTO LesArticles VALUES (1, 1, '15X21ALB', 2, 20);
INSERT INTO LesArticles VALUES (2, 4, '29.7x21MAT', 3, 14.7);
INSERT INTO LesArticles VALUES (3, 4, '30X30ALB', 1, 15);
INSERT INTO LesArticles VALUES (4, 3, '50x50BOIS', 1, 5.99);
INSERT INTO LesArticles VALUES (5, 2, '29.7x21POCH', 1, 4.99);
INSERT INTO LesArticles VALUES (6, 5, '60x20BOIS', 1, 5.9);
INSERT INTO LesArticles VALUES (7, 7, '21x14.8MAT', 1, 5.9);
INSERT INTO LesArticles VALUES (8, 6, '84.1x59.4PLAN', 1, 5.9);


--LesPhotos(_IDphoto, CheminAcces, parametres, textDescrip, noPage);

INSERT INTO LesPhotos(IDphoto, CheminAcces, noPage) VALUES (1, 'img/chien.png', 1);
INSERT INTO LesPhotos(IDphoto, CheminAcces, textDescrip, noPage) VALUES (2, 'img/ciel.png', 'Photo du ciel', 1);
INSERT INTO LesPhotos(IDphoto, CheminAcces, parametres, noPage) VALUES (3, 'img/soleil.png', 'augmenter luminosite', 2);
INSERT INTO LesPhotos(IDphoto, CheminAcces, textDescrip, noPage) VALUES (4, 'img/ann2020.png', 'annee 2020', 2);
INSERT INTO LesPhotos(IDphoto, CheminAcces, parametres, noPage) VALUES (5, 'img/world.png', 'diminuer contraste', 3);


--LesAlbums(_IDalbum, IDimpress, refrce, titre, couverture);

INSERT INTO LesAlbums VALUES (1, 3, '21X29,7ALB', 'Bonjour', 2);
INSERT INTO LesAlbums VALUES (2, 6, '15X21ALB', 'Hello World', 5);
INSERT INTO LesAlbums VALUES (3, 5, '21X21ALB', 'BD Projet', 3);
INSERT INTO LesAlbums VALUES (4, 2, '15X21ALB', 'My life', 1);


--LesCadres(_IDcadre, IDimpress, refrce);

INSERT INTO LesAlbums VALUES (1, 1, '30x30BOIS')
INSERT INTO LesAlbums VALUES (4, 11, '59.4x42PLAN')


--LesPages(noPage, MiseEnForme, IDphoto, IDalbum, IDcadre, IDcalendrier);

INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(1,2,3)
INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(1,3,3)
INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(1,5,3)
INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(2,2,1)
INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(3,1,1)
INSERT INTO LesPages(noPage,IDphoto,IDcadre) VALUES(4,5,1)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(5,1,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(6,2,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(7,3,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(8,4,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(9,5,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(10,1,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(11,2,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(12,3,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(13,4,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(14,5,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(15,1,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(16,2,4)
INSERT INTO LesPages(noPage,IDphoto,IDcalendrier) VALUES(17,3,4)


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
INSERT INTO LesStocks VALUES('84.1x59.4MAT', 20);
INSERT INTO LesStocks VALUES('59.4x42MAT', 24);
INSERT INTO LesStocks VALUES('42x29.7MAT', 33);
INSERT INTO LesStocks VALUES('29.7x21MAT', 35);
INSERT INTO LesStocks VALUES('21x14.8MAT', 60);
INSERT INTO LesStocks VALUES('84.1x59.4GLAS', 62);
INSERT INTO LesStocks VALUES('59.4x42GLAS', 20);
INSERT INTO LesStocks VALUES('42x29.7GLAS', 5);
INSERT INTO LesStocks VALUES('29.7x21GLAS', 4);
INSERT INTO LesStocks VALUES('21x14.8GLAS', 3);
INSERT INTO LesStocks VALUES('84.1x59.4POCH', 8);
INSERT INTO LesStocks VALUES('59.4x42POCH', 56);
INSERT INTO LesStocks VALUES('42x29.7POCH', 24);
INSERT INTO LesStocks VALUES('29.7x21POCH', 30);
INSERT INTO LesStocks VALUES('21x15POCH', 31);
INSERT INTO LesStocks VALUES('84.1x59.4PLAN', 55);
INSERT INTO LesStocks VALUES('59.4x42PLAN', 6);
INSERT INTO LesStocks VALUES('42x29.7PLAN', 2);
INSERT INTO LesStocks VALUES('29.7x21PLAN', 0);
INSERT INTO LesStocks VALUES('21x15PLAN', 1);
INSERT INTO LesStocks VALUES('21X29,7ALB', 1);
INSERT INTO LesStocks VALUES('15X21ALB', 2);
INSERT INTO LesStocks VALUES('21X21ALB', 6);
INSERT INTO LesStocks VALUES('30X30ALB', 3);
