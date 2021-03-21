INSERT INTO LesClients VALUES(1, 'pierre@uga.fr', 'CHEVALIER', 'Pierre', 'pierre');
INSERT INTO LesClients VALUES(2, 'samuel@uga.fr', 'LAURAS', 'Samuel', 'samuel');
INSERT INTO LesClients VALUES(3, 'joumana@uga.fr', 'ELDAKAR', 'Joumana', 'jumana');
INSERT INTO LesClients VALUES(4, 'karim@uga.fr', 'ABOUD', 'Karim', 'karim');
INSERT INTO LesClients VALUES(5, 'romeo@uga.fr', 'AGOSSOU', 'Romeo', 'romeo');
INSERT INTO LesClients VALUES(6, 'michel@lol.com', 'OUI_nom', 'michelle', 'salut');
INSERT INTO LesClients VALUES(7, 'jammy@lol.fr', 'YES', 'Jammy', 'hey');



INSERT INTO LesAdresses VALUES(1, 16, 'Rue Gustave Eiffel', 'Paris', 91130);
INSERT INTO LesAdresses VALUES(2, 74, 'Rue Banaudon', 'Paris', 69006);
INSERT INTO LesAdresses VALUES(3, 43, 'Rue de Strasbourg', 'Clermond Ferrand', 63000);
INSERT INTO LesAdresses VALUES(4, 46, 'cours Jean Jaures', 'Bordeaux', 92000);
INSERT INTO LesAdresses VALUES(5, 90, 'Avenue De Marlioz', 'Argenteuil', 95100);
INSERT INTO LesAdresses VALUES(6, 49, 'Faubourg Saint Honoré', 'Paris', 75018);
INSERT INTO LesAdresses VALUES(7, 8, 'cours Franklin Roosevelt', 'Marseille', 13010);



INSERT INTO LesCommandes VALUES(1, TO_DATE('12-03-2021','DD-MM-YYYY'), 14.00, 'En cours', 1);
INSERT INTO LesCommandes VALUES(2, TO_DATE('13-03-2021','DD-MM-YYYY'), 13.00, 'Envoyee', 2);
INSERT INTO LesCommandes VALUES(3, TO_DATE('12-03-2021','DD-MM-YYYY'), 10.00, 'Envoyee', 3);
INSERT INTO LesCommandes VALUES(4, TO_DATE('12-03-2021','DD-MM-YYYY'), 5.00, 'Pret à l''envoi', 3);
INSERT INTO LesCommandes VALUES(5, TO_DATE('12-03-2021','DD-MM-YYYY'), 6.00, 'En cours', 2);
INSERT INTO LesCommandes VALUES(6, TO_DATE('13-03-2021','DD-MM-YYYY'), 10.01, 'En cours', 1);
INSERT INTO LesCommandes VALUES(7, TO_DATE('12-03-2021','DD-MM-YYYY'), 14.02, 'En cours', 1);



INSERT INTO LesImpressions VALUES(1, 1);
INSERT INTO LesImpressions VALUES(2, 2);
INSERT INTO LesImpressions VALUES(3, 1);




INSERT INTO LesArticles VALUES(2, 30, 2, 1);


INSERT INTO LesCatalogues VALUES('papier','160x90MAT', 1.00);
INSERT INTO LesCatalogues VALUES('papier','350x200MAT', 2.00);
INSERT INTO LesCatalogues VALUES('papier','700x400MAT', 4.00);
INSERT INTO LesCatalogues VALUES('papier','160x90GLAS', 1.50);
INSERT INTO LesCatalogues VALUES('papier','350x200GLAS', 2.50);
INSERT INTO LesCatalogues VALUES('papier','700x400GLAS', 4.50);
INSERT INTO LesCatalogues VALUES('album','200x300LO', 19.90);
INSERT INTO LesCatalogues VALUES('album', '200x300HI', 29.90);
INSERT INTO LesCatalogues VALUES('album','300x200LO', 19.90);
INSERT INTO LesCatalogues VALUES('album','300x200HI', 29.90);
INSERT INTO LesCatalogues VALUES('calendrier','15x21MURAL', 5.99);
INSERT INTO LesCatalogues VALUES('calendrier','15x21BUREAU', 7.99);
INSERT INTO LesCatalogues VALUES('calendrier','30x40POSTER', 5.99);
INSERT INTO LesCatalogues VALUES('calendrier','21x28MAGNETIQUE', 7.99);
INSERT INTO LesCatalogues VALUES('cadre','160x90METAL', 4.90);
INSERT INTO LesCatalogues VALUES('cadre','350x200METAL', 9.90);
INSERT INTO LesCatalogues VALUES('cadre','160x90BOIS', 3.90);
INSERT INTO LesCatalogues VALUES('cadre','350x200BOIS', 6.90);

INSERT INTO LesFichiersImages VALUES(1, 'img/test.png', TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 9, 0);
INSERT INTO LesFichiersImages VALUES(1, 'img/test2.png', TO_DATE('13-03-2021','DD-MM-YYYY'), '<info>', 15, 1);
INSERT INTO LesFichiersImages VALUES(1, 'img/test3.png', TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 2, 0);
INSERT INTO LesFichiersImages VALUES(2, 'img/test4.png', TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 5, 1);
INSERT INTO LesFichiersImages VALUES(3, 'img/tata.png', TO_DATE('13-03-2021','DD-MM-YYYY'), '<info>', 13, 1);
INSERT INTO LesFichiersImages VALUES(3, 'img/toto.png', TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 10, 1);


/* pages */


/* photos */


/* albums */


/* cadres */


/* calendrier */


/* promotions */


/* stocks */



INSERT INTO LesTiragesPhotos VALUES(1, '160x90GLAS', 'img/test.png', '<str>', 3);



INSERT INTO LesStocks VALUES('160x90MAT', 3);
INSERT INTO LesStocks VALUES('350x200MAT', 11);
INSERT INTO LesStocks VALUES('700x400MAT', 12);
INSERT INTO LesStocks VALUES('160x90GLAS', 17);
INSERT INTO LesStocks VALUES('350x200GLAS', 5);
INSERT INTO LesStocks VALUES('700x400GLAS', 11);
INSERT INTO LesStocks VALUES('200x300LO', 17);
INSERT INTO LesStocks VALUES('200x300HI', 30);
INSERT INTO LesStocks VALUES('300x200LO', 13);
INSERT INTO LesStocks VALUES('300x200HI', 25);
INSERT INTO LesStocks VALUES('200x300LO', 21);
INSERT INTO LesStocks VALUES('200x300HI', 17);
INSERT INTO LesStocks VALUES('300x200LO', 28);
INSERT INTO LesStocks VALUES('300x200HI', 23);
INSERT INTO LesStocks VALUES('160x90METAL', 16);
INSERT INTO LesStocks VALUES('350x200METAL', 21);
INSERT INTO LesStocks VALUES('160x90BOIS', 4);
INSERT INTO LesStocks VALUES('350x200BOIS', 24);
