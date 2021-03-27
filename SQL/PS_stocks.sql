--un procédure de stockage pour supprimer les stocks qui n'existe plus 
--dans PhotonNum (quantite = 0)
CREATE OR REPLACE PROCEDURE STOCKS_NULL 
IS
BEGIN
    DELETE FROM LesStocks 
    WHERE quantite = 0;
END;
/