import java.sql.*;
import java.util.Scanner;

public class cahier_charges {
	
	static final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";

    // Ne pas oublier d'anomymiser le PASSWD avant de rendre votre travail
	
	//static final String USER = "COMPLETER";
	//static final String PASSWD = "COMPLETER";

	private static final String configurationFile = "src/tp3/BD.properties";
	static Connection conn; 
	
	
    public static void main(String args[]) {

        try {

  	    // Enregistrement du driver Oracle
  	    System.out.print("Loading Oracle driver... "); 
  	    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("loaded");
  	    
	    
  	    // Etablissement de la connection
	    DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
  	    System.out.print("Connecting to the database... "); 
 	    conn = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(),dap.getPassword());
   	    System.out.println("connected");
  	    
  	    conn.setAutoCommit(true);

	    // code m�tier de la fonctionnalit�
  	    System.out.println("Connecté à la base de donnée");
  	    Scanner sc = new Scanner(System.in);
  	    System.out.flush();

        // CAHIER DES CHARGES
		start_menu();

        creerClient(conn);

  	    // Liberation des ressources et fermeture de la connexion...
  	    sc.close();
 		conn.close(); 
 	    
  	    System.out.println("bye.");
  	    
  	    // traitement d'exception
          } catch (SQLException e) {
              System.err.println("failed");
              System.out.println("Affichage de la pile d'erreur");
  	          e.printStackTrace(System.err);
              System.out.println("Affichage du message d'erreur");
              System.out.println(e.getMessage());
              System.out.println("Affichage du code d'erreur");
  	          System.out.println(e.getErrorCode());	    

          }
    	}
		
		private static void start_menu(){
			System.out.println("
			# BIENVENUE DANS LE MENU PRINCIPAL #
			# 1.SE CONNECTER
			# 2.S'ENREGISTRER
			");
			String input_user;
			do{
				System.out.print("@ entrez 1 ou 2 :	")
				input_user = LectureClavier.lireChaine();
			}while (!(input_user.equals("1") || input_user.equals("2")));
			
			switch(input_user) {
				case "1" :
					creerClient();
					break;
				case "2" :
					connectClient();
					break;
				default :
					break;
			}
		}

        private static void creerClient(Connection conn) throws SQLException {
            System.out.println("CREATION D'UN NOUVEAU CLIENT");
            Statement stmt = conn.createStatement();
            // Demande les informations du nouveau client
        	System.out.println("Entrez vos informations");
        	String adrMail, nom, prenom, motDePasse, motDePasse2;
        	int idClient;
        	System.out.println("Entrez votre adresse mail ? ");
        	adrMail = LectureClavier.lireChaine();
        	System.out.println("Entrez est votre nom ? ");
        	nom = LectureClavier.lireChaine();
            System.out.println("Entrez est votre prénom ? ");
        	prenom = LectureClavier.lireChaine();
			// Demande le mot de passe en double
			do {
            System.out.println("Entrez votre mot de passe ? ");
        	motDePasse = LectureClavier.lireChaine();
			System.out.println("Entrez votre mot de passe à nouveau : ");
        	motDePasse2 = LectureClavier.lireChaine();
			} while (!motDePasse.equals(motDePasse2));

			// Créé un nouvel ID
			ResultSet reqIdClient = stmt.executeQuery("SELECT MAX(idClient) FROM LesClient");
			while (reqIdClient.next()) {
				idClient = reqIdClient.getInt(1) + 1;
			}
			reqIdClient.close();

			// Ajout du client dans la BD
			String query = "INSERT INTO LesClient values ('" + adrMail "', " + "'" + nom + "', " +
			"'" + prenom + "', " + "'" + motDePasse + "', " + "'" + idClient + ")";
			stmt.executeQuery(query);
			stmt.close();
			stmt.commit();
        }
        





//VVVVVVVV   A PARTIR D'ICI C'EST L'ANCIEN TP   VVVVVVVVV





		// Ajoute un nouvel animal
        private static void ajouterNouvelAnimal(Connection conn) throws SQLException {
			System.out.println("AJOUTER UN NOUVEL ANIMAL :");
        	Statement stmt = conn.createStatement();
        	// Demande les caractéristiques de l'animal à l'utilisateur
        	System.out.println("Caractéristiques de l'animal");
        	String nom, sexe, espece, fonctionCage, pays;
        	int anneeNaiss, nbMaladies;
        	System.out.println("Quel est son nom ? ");
        	nom = LectureClavier.lireChaine();
        	System.out.println("Quel est son sexe ? ");
        	sexe = LectureClavier.lireChaine();
        	System.out.println("Quel est son espèce ? ");
        	espece = LectureClavier.lireChaine();
        	System.out.println("Quel est son nom ? ");
        	nom = LectureClavier.lireChaine();
        	System.out.println("Quel est sa fonction cage ? ");
        	fonctionCage = LectureClavier.lireChaine();
        	System.out.println("Quel est son pays ? ");
        	pays = LectureClavier.lireChaine();
        	anneeNaiss = LectureClavier.lireEntier("Quel est son année de naissance ? ");
        	nbMaladies = LectureClavier.lireEntier("Quel est son nombre de maladies ? ");
    
			// Liste les cages compatibles avec l'animal
			System.out.println("Cages compatibles : ");
        	ResultSet cagesCompatibles = stmt.executeQuery("SELECT noCage, fonction_cage FROM LesCages WHERE fonction_cage = " + fonctionCage);
			while (cagesCompatibles.next()) {
				System.out.println("Num cage : " + cagesCompatibles.getInt(1));
				System.out.println("Fct cage : " + cagesCompatibles.getString(2) + "\n");
			}
			cagesCompatibles.close();

			// Ajout de l'animal dans la cage voulue par l'utilisateur
			int noCage = LectureClavier.lireEntier("Dans quelle cage ira l'animal ?");
			String query = "INSERT INTO LesAnimaux values ('" + nom + "', " + "'" + sexe + "', " +
			"'" + espece + "', " + "'" + fonctionCage + "', " + "'" + pays + "', " +
			"'" + anneeNaiss + "', " + noCage + "," + nbMaladies + ")";
			stmt.executeQuery(query);
			stmt.close();
			stmt.commit();
        }	

		// Déplace un animal
        private static void deplacerAnimal(Connection conn) throws SQLException {
        	Statement stmt = conn.createStatement();
        	// Demande le nom de l'animal
			String nom, espece, fonctionCage, pays;
        	int anneeNaiss, nbMaladies, noCage;
			System.out.println("DEPLACER UN ANIMAL :");
        	System.out.println("Quel est le nom de l'animal à déplacer ? ");
        	nom = LectureClavier.lireChaine();
			ResultSet sexe = stmt.executeQuery("SELECT sexe FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet espece = stmt.executeQuery("SELECT type_an FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet fonctionCage = stmt.executeQuery("SELECT fonction_cage FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet pays = stmt.executeQuery("SELECT pays FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet anneeNaiss = stmt.executeQuery("SELECT anNais FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet noCage = stmt.executeQuery("SELECT noCage FROM LesAnimaux WHERE nomA = " + nom);
			ResultSet nbMaladies = stmt.executeQuery("SELECT nb_maladies FROM LesAnimaux WHERE nomA = " + nom);

			// Liste les cages compatibles avec l'animal
			System.out.println("Cages compatibles : ");
        	ResultSet cagesCompatibles = stmt.executeQuery("SELECT noCage FROM LesCages WHERE fonction_cage = " + fonctionCage);
			while (cagesCompatibles.next()) {
				System.out.println("Num cage : " + cagesCompatibles.getInt(1));
			}
			cagesCompatibles.close();

			// Ajout de l'animal dans la cage voulue par l'utilisateur
			ResultSet cagesGardees = stmt.executeQuery("SELECT noCage FROM LesGardiens");
			int noNouvCage = LectureClavier.lireEntier("Dans quelle cage déplacer l'animal ? ");
			boolean trouve = false;
			boolean gardee = false;
			// Cage compatible ?
			while (cagesCompatibles.next()) {
				if (noNouvCage == cagesCompatibles.getInt(1)) {
					trouve = true;
				}
			}
			// Cage gardée ?
			while (cagesGardees.next()) {
				if (noNouvCage == cagesGardees.getInt(1)) {
					gardee = true;
				}
			}
			if (!trouve || !gardee) {
				System.out.println("Erreur cage non compatible ou non gardée");
			} else {
				String query = "INSERT INTO LesAnimaux values ('" + nom + "', " + "'" + sexe + "', " +
				"'" + espece + "', " + "'" + fonctionCage + "', " + "'" + pays + "', " +
				"'" + anneeNaiss + "', " + noNouvCage + "," + nbMaladies + ")";

				// Suppression de l'animal dans l'ancienne cage
				String query2 = "DELETE FROM LesAnimaux values ('" + nom + "', " + "'" + sexe + "', " +
				"'" + espece + "', " + "'" + fonctionCage + "', " + "'" + pays + "', " +
				"'" + anneeNaiss + "', " + noCage + "," + nbMaladies + ")";
				stmt.executeQuery(query);
				stmt.executeQuery(query2);
			}
			stmt.close();
			stmt.commit();
        }	

		// Affecter un gardien à une cage
        private static void affecterGardienACage(Connection conn) throws SQLException {
        	Statement stmt = conn.createStatement();
        	// Demande le nom du gardien
			String nom, fonctionCage;
        	int noCage;
			System.out.println("AFFECTER UN GARDIEN A UNE CAGE :");
        	System.out.println("Quel est le nom du gardien à affecter ? ");
        	nom = LectureClavier.lireChaine();
			ResultSet fonctionCage = stmt.executeQuery("SELECT fonction_cage FROM LesSpecialites WHERE nomE = " + nom);
			ResultSet noCage = stmt.executeQuery("SELECT noCage FROM LesGardiens WHERE nomE = " + nom);

			// Liste les cages compatibles avec le gardien
			System.out.println("Cages compatibles : ");
        	ResultSet cagesCompatibles = stmt.executeQuery("SELECT noCage FROM LesCages WHERE fonction_cage = " + fonctionCage);
			while (cagesCompatibles.next()) {
				System.out.println("Num cage : " + cagesCompatibles.getInt(1));
			}
			cagesCompatibles.close();

			// Ajout du gardien à sa cage
			boolean trouve = false;
			while (cagesCompatibles.next()) {
				if (noCage == cagesCompatibles.getInt(1)) {
					trouve = true;
				}
			}
			if (!trouve) {
				System.out.println("Erreur cage non compatible avec la spécialité du gardien");
			} else {
				String query = "INSERT INTO LesGardiens values (" + noCage + ", '" + nom + ")";
				stmt.executeQuery(query);
			}
			stmt.close();
			stmt.commit();
        }	

		// Ajoute une maladie à un animal
        private static void ajouterMaladieAnimal(Connection conn) throws SQLException {
			System.out.println("AJOUTER UNE MALADIE A UN ANIMAL :");
        	Statement stmt = conn.createStatement();
        	// Demande les caractéristiques de la maladie et de l'animal
        	String nomA, nomM;
        	int nbMaladies;
        	System.out.println("Quel est le nom de l'animal ? ");
        	nomA = LectureClavier.lireChaine();
        	System.out.println("Quel est le nom de la maladie ? ");
        	nomM = LectureClavier.lireChaine();

			String query = "INSERT INTO LesMaladies values ('" + nomA + "', " + "'" + nomM + ")";
			String query2 = "UPDATE LesAnimaux set nb_maladies=nb_maladies+1 where nomA="+nomA;
			stmt.executeQuery(query);
			stmt.executeQuery(query2);
			stmt.close();
			stmt.commit();

			/* TRIGGER CORRESPONDANT :
			CREATE OR REPLACE TRIGGER UPDATE_NBMALADIE
			BEFORE INSERT ON LesMaladies
			DECLARE
				nomAnimal LesMaladies%nomA := New:nomA;
			FOR EACH ROW
			BEGIN
				UPDATE LesAnimaux
				SET nb_maladies = nb_maladies + 1
				WHERE nomA = new:nomA;
				dbms_output.put_line('OK');
			END
			*/

			/*

			CREATE OR REPLACE PROCEDURE RETIRE_GARDIEN_CAGE_NON_VIDE
			IS
			BEGIN
				UPDATE LesGardiens
				SET nomE=NULL; noCage=NULL;
				WHERE ???;
			END

			*/

        }	

}