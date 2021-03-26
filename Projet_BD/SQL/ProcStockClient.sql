--Un procédure pour afficher les clients pour une ville donnée
CREATE PROCEDURE Client @Ville nvarchar(30)
AS
SELECT prenom FROM LesAdresses 
NATURAL JOIN LesClients 
WHERE ville = @Ville
GO;