INSERT INTO LesClients VALUES(1, 'pierre@uga.fr', 'CHEVALIER', 'Pierre', 'pierre');
INSERT INTO LesClients VALUES(2, 'samuel@uga.fr', 'LAURAS', 'Samuel', 'samuel');
INSERT INTO LesClients VALUES(3, 'joumana@uga.fr', 'ELDAKAR', 'Joumana', 'joumana');
INSERT INTO LesClients VALUES(4, 'karim@uga.fr', 'ABOUD', 'Karim', 'karim');
INSERT INTO LesClients VALUES(5, 'romeo@uga.fr', 'AGOSSOU', 'Romeo', 'romeo');
INSERT INTO LesClients VALUES(6, 'michel@lol.com', 'OUI_nom', 'michelle', 'salut');
INSERT INTO LesClients VALUES(7, 'jammy@lol.fr', 'YES', 'Jammy', 'hey');



INSERT INTO LesAdresses VALUES(16, 'Rue Gustave Eiffel', 'Paris', 91130, 1);
INSERT INTO LesAdresses VALUES(74, 'Rue Banaudon', 'Paris', 69006, 2);
INSERT INTO LesAdresses VALUES(43, 'Rue de Strasbourg', 'Clermond Ferrand', 63000, 3);
INSERT INTO LesAdresses VALUES(46, 'cours Jean Jaures', 'Bordeaux', 92000, 4);
INSERT INTO LesAdresses VALUES(90, 'Avenue De Marlioz', 'Argenteuil', 95100, 5);
INSERT INTO LesAdresses VALUES(49, 'Faubourg Saint Honoré', 'Paris', 75018, 6);
INSERT INTO LesAdresses VALUES(8, 'cours Franklin Roosevelt', 'Marseille', 13010, 7);



INSERT INTO LesCommandes VALUES(1, TO_DATE('12-03-2021','DD-MM-YYYY'), 14.00, 'En cours', 1);
INSERT INTO LesCommandes VALUES(2, TO_DATE('13-03-2021','DD-MM-YYYY'), 13.00, 'Envoyee', 2);
INSERT INTO LesCommandes VALUES(3, TO_DATE('12-03-2021','DD-MM-YYYY'), 10.00, 'Envoyee', 3);
INSERT INTO LesCommandes VALUES(4, TO_DATE('12-03-2021','DD-MM-YYYY'), 5.00, 'Pret a l''envoi', 3);
INSERT INTO LesCommandes VALUES(5, TO_DATE('12-03-2021','DD-MM-YYYY'), 6.00, 'En cours', 2);
INSERT INTO LesCommandes VALUES(6, TO_DATE('13-03-2021','DD-MM-YYYY'), 10.01, 'En cours', 1);
INSERT INTO LesCommandes VALUES(7, TO_DATE('12-03-2021','DD-MM-YYYY'), 14.02, 'En cours', 1);



INSERT INTO LesImpressions VALUES(1, 1);
INSERT INTO LesImpressions VALUES(2, 2);
INSERT INTO LesImpressions VALUES(3, 1);




INSERT INTO LesArticles VALUES(2, 1, 30, 2);


INSERT INTO LesCatalogues VALUES('160x90MAT', 'papier', 1);
INSERT INTO LesCatalogues VALUES('350x200MAT', 'papier', 2);
INSERT INTO LesCatalogues VALUES('700x400MAT', 'papier', 4);
INSERT INTO LesCatalogues VALUES('160x90GLAS', 'papier', 1.5);
INSERT INTO LesCatalogues VALUES('350x200GLAS', 'papier', 2.5);
INSERT INTO LesCatalogues VALUES('700x400GLAS', 'papier', 4.5);
INSERT INTO LesCatalogues VALUES('200x300LO', 'album', 19.9);
INSERT INTO LesCatalogues VALUES('200x300HI', 'album', 29.9);
INSERT INTO LesCatalogues VALUES('300x200LO', 'album', 19.9);
INSERT INTO LesCatalogues VALUES('300x200HI', 'album', 29.9);
INSERT INTO LesCatalogues VALUES('15x21MURAL', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES('15x21BUREAU', 'calendrier', 7.99);
INSERT INTO LesCatalogues VALUES('30x40POSTER', 'calendrier', 5.99);
INSERT INTO LesCatalogues VALUES('21x28MAGNETIQUE', 'calendrier', 7.99);
INSERT INTO LesCatalogues VALUES('160x90METAL', 'cadre', 4.9);
INSERT INTO LesCatalogues VALUES('350x200METAL', 'cadre', 9.9);
INSERT INTO LesCatalogues VALUES('160x90BOIS', 'cadre', 3.9);
INSERT INTO LesCatalogues VALUES('350x200BOIS', 'cadre', 6.9);



INSERT INTO LesFichierImages VALUES('img/test.png', 1, TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 9, 0);
INSERT INTO LesFichierImages VALUES('img/test2.png', 1, TO_DATE('13-03-2021','DD-MM-YYYY'), '<info>', 15, 1);
INSERT INTO LesFichierImages VALUES('img/test3.png', 1, TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 2, 0);
INSERT INTO LesFichierImages VALUES('img/test4.png', 2, TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 5, 1);
INSERT INTO LesFichierImages VALUES('img/tata.png', 3, TO_DATE('13-03-2021','DD-MM-YYYY'), '<info>', 13, 1);
INSERT INTO LesFichierImages VALUES('img/toto.png', 3, TO_DATE('12-03-2021','DD-MM-YYYY'), '<info>', 10, 1);


/* pages */


/* photos */


/* albums */


/* cadres */


/* calendrier */


/* promotions */



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
