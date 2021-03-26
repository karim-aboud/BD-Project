package metiers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import dao.*;

public class MenuPrincipale extends ConnectionClient {
	private int id_client;
	
	public MenuPrincipale(Connection conn, int id_client) {
		super(conn);
		this.id_client = id_client;
	}
	
	public void print(String s) {
		System.out.print(s);
	}
	
	public void printMenu(String s) {
		System.out.print("\n-------------- " + s + " --------------\n\n");
	}
	
	public  void clear() {
		int i =0;
		while(i < 50) {
			System.out.println();
			i++;
		}
	}
	
	public int menuSelector(String[] args) {
		for (int i =0; i<args.length; i++ ) {
			if (i==0) {
				printMenu(args[i]);
			} else {
				System.out.print(args[i] + "\n");
			}
		}
		return userInputNumber(args.length);
	}
	
	public  int userInputNumber(int length) {	
		// user peut rentrer UNIQUEMENT 1,2...,length-1
		String s;
		Integer n;
		do {
			System.out.print("\n/. selectioner menu? ->");
			s = LectureClavier.lireChaine();
			try {
				n = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				n = null;
			}
		} while (n == null || !(n > 0 && n< length ));
		return n;
	}
	
	public  void menuPrincipal() throws SQLException {
		String[] myMenu = {"MENU PRINCIPAL",
				"1.Gestion des Images",
				"2.Gestion des Impressions",
			    "3.Gestion des Commandes",
			    "4.Profil et adresses"};
		
		switch(menuSelector(myMenu)) {
		case 1:
			clear();
			menuImages();
			break;
		case 2:
			clear();
			menuImpressions();
			break;
		case 3:
			clear();
			menuCommandes();
			break;
		case 4:
			clear();
			menuProfil();
			break;
		default:
			break;
		}
		
	}
	
	public  void menuImages() throws SQLException {
		String[] imagesMenu = {"MENU / GESTION DE MES IMAGES",
				"1.voir ma collection d'images",
				"2.voir les images issus de partages",
				"3.telecharger(upload) une image",
				"4.Ajouter une image partagee",
				"5.partager une image perso",
				"6.supprimer une image",
				"7.retour"};
		
		ClientDAO clientDAO = new ClientDAO(conn);
		FichierImageDAO fichierDAO = new FichierImageDAO(conn);
		Statement myStm;
		ResultSet rs;
		
		switch(menuSelector(imagesMenu)) {
		case 1:
			//TODO
			
			/* avec l'ID du client on obtient les cheminAcces avec lesquels on pourra voir 
			 les images du client 
			 */
			Client client = clientDAO.read(id_client);
			client.printListeFichiersImages();
						
			menuImages();
			break;
		case 2:
			//TODO
			
		    myStm = conn.createStatement(this.type,this.mode);
			String fichiersPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=1";
						
			rs = myStm.executeQuery(fichiersPartages);
			rs.beforeFirst();		 
			
			print("\n");
			
			while(rs.next()) {
				System.out.println(rs.getString("CheminAcces"));
			}
			
			
			menuImages();
			break;
			
		case 3:
			
			print("\nIndiquez le chemin d'acces du fichier a telecharger ->");
			String chemin = LectureClavier.lireChaine();
			FichierImage nouveauFichierImage = new FichierImage();
			
			nouveauFichierImage.setChemin_acces(chemin);
			nouveauFichierImage.setId_client(id_client);
			
			long millis=System.currentTimeMillis();  
		    Date date=new Date(millis); 
		    
		    nouveauFichierImage.setDate_creation(date);
			nouveauFichierImage.setEst_partage(0); // le fichier n'est pas partage par default
			
			if (fichierDAO.create(nouveauFichierImage)) {
				System.out.println("\nLe fichier image '"+chemin+"' a ete telecharge.\n");
			}
			
			menuImages();
			break;
			
		case 4:
			
			//TODO
			print("nom implementée");
			menuImages();
			break;
			
		case 5:
			
			myStm = conn.createStatement(this.type,this.mode);
			String fichiersNonPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=0";
						
			rs = myStm.executeQuery(fichiersNonPartages);
			rs.beforeFirst();		 
			
			print("\n");
			print("Vos fichiers non partages sont:\n\n");
			
			while(rs.next()) {
				System.out.println(rs.getString("CheminAcces"));
			}
			
			
			print("\nQuel image voulez vous partager ? (indiquez le chemin d'acces) ->");
			String imgAPartager = LectureClavier.lireChaine();
			
			FichierImage fi = fichierDAO.read(imgAPartager);		
			fi.setEst_partage(1);
 			fichierDAO.update(fi);
 			print("\nLe fichier "+fi.getChemin_acces()+" est maintenant partage.");
			menuImages();
			break;
			
		case 6:
			// Supprimer fichiers image supprime le fichier (de la table LesFichiersImages)
			// et bien sur la photo contenue dans le fichier (de la table LesPhotos)
			
			myStm = conn.createStatement(this.type,this.mode);
			String fichiersImages = "SELECT CheminAcces FROM LesFichiersImages "
					+ "WHERE IDclient="+id_client;
						
			rs = myStm.executeQuery(fichiersImages);
			rs.beforeFirst();		 
			
			print("\n");
			print("Vos fichiers images sont:\n\n");
			
			while(rs.next()) {
				System.out.println(rs.getString("CheminAcces"));
			}
			
			print("\nQuel image voulez vous supprimez ? (indiquez le chemin d'acces) ->");
			String imgASup = LectureClavier.lireChaine();
			
			FichierImage fiASup = fichierDAO.read(imgASup);		
 			fichierDAO.delete(fiASup);
 			print("\nLe fichier "+fiASup.getChemin_acces()+" a ete supprime.\n");
			menuImages();
			break;
			
		case 7:
			clear();
			menuPrincipal();
			break;
			
		default:
			break;
		}

	}
	
	public  void menuImpressions() throws SQLException {
		String[] impressionMenu = {"MENU / GESTION DE MES IMPRESSIONS",
				"1.voir mes impressions",
				"2.creer",
				"3.retour"};
		
		switch(menuSelector(impressionMenu)) {
		case 1:
			//TODO voir mes impressions
			print("nom implementée");
			menuImpressions();
			break;
			
		case 2:
			clear();
			String[] impressionTypeMenu = {"MENU / GESTION DE MES IMPRESSIONS / NOUVELLE IMPRESSION / TYPE ???",
					"1. Tirage photo",
					"2. Calendrier",
					"3. Album",
					"4. Cadre",
					"5. Retour"};
			switch(menuSelector(impressionTypeMenu)) {
			case 1:
				//TODO
				print("nom implementée");
				menuImpressions();
				break;
			case 2:
				//TODO
				print("nom implementée");
				menuImpressions();
				break;
			case 3:
				//TODO
				print("nom implementée");
				menuImpressions();
				break;
			case 4:
				//TODO
				print("nom implementée");
				menuImpressions();
				break;
			case 5:
				//TODO
				print("nom implementée");
				menuImpressions();
				break;
			default:
				break;
			}
			break;
		case 3:
			clear();
			menuPrincipal();
			break;
		default:
			break;
		}

	}
	
	public  void menuCommandes() throws SQLException {
		Statement myStm;
		ResultSet rs;
		
		String[] cmdMenu = {"MENU / GESTION DE MES COMMANDES",
				"1.voir mes commandes",
				"2.passer une nouvelle commande",
				"3.retour"};
		
		switch(menuSelector(cmdMenu)) {
		
		case 1:
			
			myStm = conn.createStatement(this.type,this.mode);
			String commandes = "SELECT * FROM LesCommandes "
					+ "WHERE IDclient="+id_client;
						
			rs = myStm.executeQuery(commandes);
			rs.beforeFirst();		 
			
			print("\n");
			print("Vos commandes sont:\n\n");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			for(int i = 1 ; i <= columnsNumber ; i++){
				  if(i==2) {
					  continue;
				  }
	    	      System.out.print(rsmd.getColumnName(i) + " "); 

	    	}
			
			while(rs.next()) {
				System.out.println("\n      "+rs.getInt("IDcommande")+ "    " +
									rs.getDate("DateCommande")+ "     "+
								   rs.getFloat("prixTOTAL")+ "      "+
									rs.getString("statut"));
			}
			
			print("\n");
			
			menuCommandes();	
			break;
			
		case 2:
			clear();
			printMenu("MENU / GESTION DE MES COMMANDES / NOUVELLE COMMANDES / TYPE ???");
			boolean encore = true;
			while(encore) {
				/*TODO afficher N valeurs des Impressions du clients*/
				/*int n = userInputNumber(int length) utiliser ce n pour choisir l'impression voulue*/
				
				String nbleft = null; /*stock de cette impresion*/
				print("nombre d'exemplaire ? (il en reste"+ nbleft + ") :");
				/*TODO*/
				/*int nbExplaire = userInputNumber(nbleft) utiliser ce n pour choisir l'impression voulue*/
				
				print("\n");
				String[] cmdEncore = {"ajouter encore des Article a ctte commande ?",
						"1.oui, encore !",
						"2.non merci"};
				if(menuSelector(cmdEncore) == 2){
					encore = false;
				}	
			}
			print("\nSaisissez un mode de paiement :");
			LectureClavier.lireChaine();
			/*TODO effectuer la transaction*/
			print("\n\nPaiement effectue ! RETOUR au menu precedant...");
			menuCommandes();
			break;
			
		case 3:
			clear();
			menuPrincipal();
			break;
			
		default:
			break;
		}
		
	}
	
	public  void menuProfil() throws SQLException {
		
		ClientDAO clientDAO = new ClientDAO(conn);
	
		String[] cmdMenu = {"MENU / PROFIL & ADRESSES",
				"1.voir",
				"2.ajouter une adresse",
				"3.retour"};
		
		switch(menuSelector(cmdMenu)) {
		case 1:
			
			Client client = clientDAO.read(id_client);
			System.out.print("\nEMAIL: ");
			System.out.println(client.getAdrMail());
			System.out.print("NOM: ");
			System.out.println(client.getNom());
			System.out.print("PRENOM: ");
			System.out.println(client.getPrenom()+"\n");
			
			menuProfil();
			break;
		case 2:
			/*TODO*/
			printMenu("ajout d'une adresse");
			print("numero :");
			LectureClavier.lireChaine();
			print("rue :");
			LectureClavier.lireChaine();
			print("code postal :");
			LectureClavier.lireChaine();
			print("ville :");
			LectureClavier.lireChaine();
			
			clear();
			printMenu("adresse ajoutee");
			menuProfil();
			break;
		case 3:
			clear();
			menuPrincipal();
			break;
		default:
			break;
		}
			
	}
	
	
	
}