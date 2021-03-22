package projet;

import java.sql.*;

public class ConnectionSQL {
	/**
     * URL de connexion
     */
    private static String url = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    /**
     * Nom du user
     */
    private static String user = "chevallp";
    /**
     * Mot de passe du user
     */
    private static String passwd = "pierre";
    /**
     * Objet Connexion
     */
    private static Connection connect;
    
    /**
     * M�thode qui va nous retourner notre instance
     * et la cr�er si elle n'existe pas...
     * @return
     */
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
        return connect;    
    } 
}
