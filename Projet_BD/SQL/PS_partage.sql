--un procédure pour afficher les fichiers images partagée par les clients
CREATE OR REPLACE PROCEDURE Partage 
IS
BEGIN
    SELECT nom, prenom, CheminAcces, Resolution, InfoPriseVue FROM LesFichiersImages 
    NATURAL JOIN LesClients 
    WHERE estPartage = 1
END;
/