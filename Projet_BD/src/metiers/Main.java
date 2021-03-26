package metiers;
import java.sql.*;
import dao.ClientDAO;
import dao.DAO;
import metiers.MenuPrincipale;



public class Main {

	static Connection conn;

	public static void main(String[] args) throws SQLException {
		conn = TheConnection.getInstance();
		DAO<Client> clientDao = new ClientDAO(conn);
		
		
		//Client client =  clientDao.read(1);
		//System.out.println(client);
		
		
		int id_client=0;
		
		
		System.out.println("####################\n"+
						   "#     Bienvenue    #\n"+
						   "####################\n" );
		
		String option;
		
		do {
			System.out.println("Choisissez une option (1 ou 2):");
			System.out.println("1 - Creer un compte");
			System.out.println("2 - Se connecter");
			option = LectureClavier.lireChaine();
		} while (!option.equals("1") && !option.equals("2") );
		
		ConnectionClient connect = new ConnectionClient(conn);
		
		switch(option){
			case "1": 
				connect.creerUnCompte() ;
			
			case "2": 
			
				id_client = connect.connectionCompte();
			
			    Client client =  clientDao.read(id_client);
			    
			    MenuPrincipale menu = new MenuPrincipale(conn,id_client);
			    menu.print("\nConnection Réussie!\nBonjour, "+client.getPrenom()+"\n");
			    menu.menuPrincipal();
			    
			    
				break;
			default: break;
		}
		
	
	
	}


}
