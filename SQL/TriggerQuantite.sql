--Trigger pour diminuer la quantité de stocks quand un article acheté
CREATE OR REPLACE TRIGGER QUANTITE_STOCK
AFTER INSERT ON LesArticles
FOR EACH ROW  
BEGIN
    UPDATE LesStocks 
    SET quantite = quantite - ( SELECT quantite FROM LesArticles)
END;
/