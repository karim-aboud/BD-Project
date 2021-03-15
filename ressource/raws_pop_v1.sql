

INSERT INTO LesClients VALUES(1, 'pierre@uga.fr', 'CHEVALIER', 'Pierre', 'pierre');
INSERT INTO LesClients VALUES(2, 'samuel@uga.fr', 'LAURAS', 'Samuel', 'samuel');
INSERT INTO LesClients VALUES(3, 'joumana@uga.fr', 'ELDAKAR', 'Joumana', 'jumana');
INSERT INTO LesClients VALUES(4, 'karim@uga.fr', 'ABOUD', 'Karim', 'karim');
INSERT INTO LesClients VALUES(5, 'romeo@uga.fr', 'AGOSSOU', 'Romeo', 'romeo');
INSERT INTO LesClients VALUES(6, 'michel@lol.com', 'OUI_nom', 'michelle', 'salut');
INSERT INTO LesClients VALUES(7, 'jammy@lol.fr', 'YES', 'Jammy', 'hey');







INSERT INTO LesAdresses VALUES(1, 18, 'rue monmarte', 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES(1, 20, 'rue monmarte', 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES(2, 1, 'rue de malade', 'Paris', 92000);
INSERT INTO LesAdresses VALUES(2, 100, 'rue de ouf', 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES(3, 8, 'rue moyenne', 'Lyon', 69230);
INSERT INTO LesAdresses VALUES(4, 2, 'rue de malade', 'Paris', 92000);
INSERT INTO LesAdresses VALUES(5, 10, 'rue de ouf', 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES(5, 8, 'rue moyenne', 'Lyon', 69230);
INSERT INTO LesAdresses VALUES(6, 3, 'rue de malade', 'Paris', 92000);
INSERT INTO LesAdresses VALUES(6, 10, 'rue de ouf', 'Grenoble', 38000);
INSERT INTO LesAdresses VALUES(7, 8, 'rue moyenne', 'Lyon', 69230);



INSERT INTO LesCommandes VALUES(1, 12-03-2021, 14.00, 'EN_COURS', 1);
INSERT INTO LesCommandes VALUES(2, 13-03-2021, 13.00, 'ENVOYEE', 2);
INSERT INTO LesCommandes VALUES(3, 12-03-2021, 10.00, 'TERMINE', 3);
INSERT INTO LesCommandes VALUES(4, 12-02-2021, 5.00, 'PRET', 3);
INSERT INTO LesCommandes VALUES(5, 12-03-2021, 6.00, 'EN_COURS', 2);
INSERT INTO LesCommandes VALUES(6, 13-03-2021, 10.01, 'EN_COURS', 1);
INSERT INTO LesCommandes VALUES(7, 12-03-2021, 14.02, 'EN_COURS', 1);



INSERT INTO LesImpressions VALUES(1, 1);
INSERT INTO LesImpressions VALUES(2, 2);
INSERT INTO LesImpressions VALUES(3, 1);





INSERT INTO LesArticles VALUES(2, 30, 2, 1);





INSERT INTO LesTiragesLesPhotos VALUES(1, '160x90GLAS', 'img/test.png', '<str>', 3);




INSERT INTO LesFichierImages VALUES(1, 'img/test.png', 44267, '<info>', 9, 0);
INSERT INTO LesFichierImages VALUES(1, 'img/test2.png', 44260, '<info>', 15, 1);
INSERT INTO LesFichierImages VALUES(1, 'img/test3.png', 44272, '<info>', 2, 0);
INSERT INTO LesFichierImages VALUES(2, 'img/test4.png', 44239, '<info>', 5, 1);
INSERT INTO LesFichierImages VALUES(3, 'img/toip.png', 44260, '<info>', 13, 1);
INSERT INTO LesFichierImages VALUES(3, 'img/toto.png', 44231, '<info>', 10, 1);


INSERT INTO LesCatalogues VALUES(tirage, '160x90', 'MAT', '160x90MAT', 1.00);
INSERT INTO LesCatalogues VALUES(tirage, '350x200', 'MAT', '350x200MAT', 2.00);
INSERT INTO LesCatalogues VALUES(tirage, '700x400', 'MAT', '700x400MAT', 4.00);
INSERT INTO LesCatalogues VALUES(tirage, '160x90', 'GLAS', '160x90GLAS', 1.50);
INSERT INTO LesCatalogues VALUES(tirage, '350x200', 'GLAS', '350x200GLAS', 2.50);
INSERT INTO LesCatalogues VALUES(tirage, '700x400', 'GLAS', '700x400GLAS', 4.50);
INSERT INTO LesCatalogues VALUES(album, '200x300', 'LO', '200x300LO', 19.90);
INSERT INTO LesCatalogues VALUES(album, '200x300', 'HI', '200x300HI', 29.90);
INSERT INTO LesCatalogues VALUES(album, '300x200', 'LO', '300x200LO', 19.90);
INSERT INTO LesCatalogues VALUES(album, '300x200', 'HI', '300x200HI', 29.90);
INSERT INTO LesCatalogues VALUES(calendrier, '200x300', 'LO', '200x300LO', 5.99);
INSERT INTO LesCatalogues VALUES(calendrier, '200x300', 'HI', '200x300HI', 7.99);
INSERT INTO LesCatalogues VALUES(calendrier, '300x200', 'LO', '300x200LO', 5.99);
INSERT INTO LesCatalogues VALUES(calendrier, '300x200', 'HI', '300x200HI', 7.99);
INSERT INTO LesCatalogues VALUES(cadre, '160x90', 'METAL', '160x90METAL', 4.90);
INSERT INTO LesCatalogues VALUES(cadre, '350x200', 'METAL', '350x200METAL', 9.90);
INSERT INTO LesCatalogues VALUES(cadre, '160x90', 'BOIS', '160x90BOIS', 3.90);
INSERT INTO LesCatalogues VALUES(cadre, '350x200', 'BOIS', '350x200BOIS', 6.90);



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
