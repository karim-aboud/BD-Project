--Trigger pour supprimer les fichier images qui ont passés les 10 jours de la date de création sans utilisation 
CREATE OR REPLACE TRIGGER FICHIER_10JOURS
BEFORE INSERT OR UPDATE ON LesFichiersImages
FOR EACH ROW  
BEGIN
    DELETE FROM LesFichiersImages 
    WHERE SYSDATE - LesFichiersImages.DateCreation > 10;
END;
/