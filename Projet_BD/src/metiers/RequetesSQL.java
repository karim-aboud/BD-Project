package metiers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AdresseDAO;
import dao.AlbumDAO;
import dao.CadreDAO;
import dao.CalendrierDAO;
import dao.ClientDAO;
import dao.FichierImageDAO;
import dao.ImpressionDAO;
import dao.TiragePhotoDAO;

	public  class RequetesSQL extends ConnectionClient{
		
	private int id_client;	
	ClientDAO clientDAO = new ClientDAO(conn);
	FichierImageDAO fichierDAO = new FichierImageDAO(conn);
	AlbumDAO albumDAO = new AlbumDAO(conn);
	ImpressionDAO impressionDAO = new ImpressionDAO(this.conn);
	CadreDAO cadreDAO = new CadreDAO(this.conn);
	CalendrierDAO calendrierDAO = new CalendrierDAO(this.conn);
	TiragePhotoDAO tirageDAO = new TiragePhotoDAO(this.conn);
	AdresseDAO adresseDAO = new AdresseDAO(this.conn);
	
	Statement Stm;
	ResultSet rs;

	
	public RequetesSQL(Connection conn,int id_client) {
		super(conn);
		this.id_client=id_client;
	}
	
	public void print(String s) {
		System.out.print(s);
	}
	
	public  void voirCollectionImages() {
		/*
		 * avec l'ID du client on obtient les cheminAcces avec lesquels on pourra voir
		 * les images du client
		 */
		Client client = clientDAO.read(id_client);
		client.printListeFichiersImages();
	}
	
	public void voirImpression() throws SQLException {
		String id_impress = "SELECT IDimpress FROM LesImpressions WHERE IDclient=" + id_client;

		rs = Stm.executeQuery(id_impress);

		// VERIFICATION SI ResultSet est VIDE.
		if (rs.next() == false) {
			System.out.println("\nVous n'avez pas encore creer des impressions.\n");
			
		} else {

			while (rs.next()) {

				Album alb = albumDAO.read(rs.getInt("IDimpress"));
				Cadre cadre = cadreDAO.read(rs.getInt("IDimpress"));
				Calendrier calendrier = calendrierDAO.read(rs.getInt("IDimpress"));
				TiragePhoto tirage = tirageDAO.read(rs.getInt("IDimpress"));

				if (alb.getId_impression() != 0) {
					System.out.println(alb);
				} else if (cadre.getId_impression() != 0) {
					System.out.println(cadre);
				} else if (calendrier.getId_impression() != 0) {
					System.out.println(calendrier);

				} else {
					System.out.println(tirage);
				}
			}

		}
	}
	
	public void creationAlbum() throws SQLException {
		
		String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

		rs = Stm.executeQuery(newImprId);
		rs.next();

		int id_imp = rs.getInt("IDimpress");
		impressionDAO.create(new Impression(id_imp, id_client));
		
		
		String refAlbums = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
				+ "LesStocks WHERE SUPPORT='album' AND QUANTITE > 0 ";

		rs = Stm.executeQuery(refAlbums);
		System.out.println("\nLes references d'albums dans le catalogue (et disponible en stock): ");

		while (rs.next()) {
			System.out.println(rs.getString("REFRCE"));
		}

		print("\nEntrer une reference d'album a partir du catalogue: \n");

		String ref = LectureClavier.lireChaine();
		print("Donnez un titre a l'album: ");
		String titre = LectureClavier.lireChaine();

		String pagesCouverturesPossible = "SELECT IDpage FROM " + "LesPages NATURAL JOIN LesAlbums";

		rs = Stm.executeQuery(pagesCouverturesPossible);
		System.out.println("\nLes pages disponibles comme couverture pour les albums: ");

		while (rs.next()) {
			System.out.println(rs.getInt("IDpage"));
		}

		int pageCouv = LectureClavier.lireEntier("\nChoisissez une page de couverture");
		
		Album alb = new Album(id_imp, ref, titre, pageCouv);
		albumDAO.create(alb);
		print("\nL'album a ete cree.\n");
	}
	
	
	public void voirCommandes() throws SQLException {
		Stm = conn.createStatement(this.type, this.mode);
		String commandes = "SELECT * FROM LesCommandes " + "WHERE IDclient=" + id_client;

		rs = Stm.executeQuery(commandes);
		rs.beforeFirst();
		
		if(rs.first()) {
			print("\n");
			print("Vos commandes sont:\n\n");

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			for (int i = 1; i <= columnsNumber; i++) {
				if (i == 2) {
					continue;
				}
				System.out.print(rsmd.getColumnName(i) + " ");

			}

			while (rs.next()) {
				System.out.println("\n      " + rs.getInt("IDcommande") + "    " + rs.getDate("DateCommande") + "     "
						+ rs.getFloat("prixTOTAL") + "      " + rs.getString("statut"));
			}
		} else {
			System.out.println("\nVous n'avez pas encore de commandes.");
		}
	}
	
	public void voirProfile() {
		Client client = clientDAO.read(id_client);
		System.out.print("\nEMAIL: ");
		System.out.println(client.getAdrMail());
		System.out.print("NOM: ");
		System.out.println(client.getNom());
		System.out.print("PRENOM: ");
		System.out.println(client.getPrenom() + "\n");

		client.printListeAdresses();
	}
	
	public void ajouterAdresse() throws SQLException {
		Client client = clientDAO.read(id_client);
		int num = LectureClavier.lireEntier("numero: ");
		print("rue :");
		String rue = LectureClavier.lireChaine();
		int codepostal = LectureClavier.lireEntier("code postal: ");
		print("ville :");
		String ville = LectureClavier.lireChaine();

		String newAdrId = "SELECT MAX(IDadresse)+1 AS IDadresse FROM LesAdresses";
		Statement Stm = conn.createStatement(this.type, this.mode);
		ResultSet rs = Stm.executeQuery(newAdrId);
		rs.next();
		int idAdr = rs.getInt("IDadresse");

		Adresse adr = new Adresse(idAdr, num, rue, ville, codepostal, id_client);
		client.addAdresse(adr);
		adresseDAO.create(adr);
		System.out.println("\nL'Adresse a ete ajoute.");
	}
	
	public void voirImagesPartages() throws SQLException {
		Stm = conn.createStatement(this.type, this.mode);
		String fichiersPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=1";

		rs = Stm.executeQuery(fichiersPartages);
		rs.beforeFirst();

		print("\n");

		while (rs.next()) {
			System.out.println(rs.getString("CheminAcces"));
		}
	}
	
	public void telechargerImage() {
		print("\nIndiquez le chemin d'acces du fichier a telecharger ->");
		String chemin = LectureClavier.lireChaine();
		FichierImage nouveauFichierImage = new FichierImage();

		nouveauFichierImage.setChemin_acces(chemin);
		nouveauFichierImage.setId_client(id_client);

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		nouveauFichierImage.setDate_creation(date);
		nouveauFichierImage.setEst_partage(0); // le fichier n'est pas partage par default

		if (fichierDAO.create(nouveauFichierImage)) {
			System.out.println("\nLe fichier image '" + chemin + "' a ete telecharge.\n");
		}
	}
	
	public void partagerImagePerso() throws SQLException {
		Stm = conn.createStatement(this.type, this.mode);
		String fichiersNonPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=0";

		rs = Stm.executeQuery(fichiersNonPartages);
		rs.beforeFirst();

		print("\n");
		print("Vos fichiers non partages sont:\n\n");

		while (rs.next()) {
			System.out.println(rs.getString("CheminAcces"));
		}

		print("\nQuel image voulez vous partager ? (indiquez le chemin d'acces) ->");
		String imgAPartager = LectureClavier.lireChaine();

		FichierImage fi = fichierDAO.read(imgAPartager);
		fi.setEst_partage(1);
		fichierDAO.update(fi);
		print("\nLe fichier " + fi.getChemin_acces() + " est maintenant partage.\n");
	}
	
	public void supprimerImage() throws SQLException {
		Stm = conn.createStatement(this.type, this.mode);
		String fichiersImages = "SELECT CheminAcces FROM LesFichiersImages " + "WHERE IDclient=" + id_client;

		rs = Stm.executeQuery(fichiersImages);
		rs.beforeFirst();

		print("\n");
		print("Vos fichiers images sont:\n\n");

		while (rs.next()) {
			System.out.println(rs.getString("CheminAcces"));
		}

		print("\nQuel image voulez vous supprimez ? (indiquez le chemin d'acces) ->");
		String imgASup = LectureClavier.lireChaine();

		FichierImage fiASup = fichierDAO.read(imgASup);
		fichierDAO.delete(fiASup);
		print("\nLe fichier " + fiASup.getChemin_acces() + " a ete supprime.\n");
	}
	
	public int decrementerStock(String ref, int qte) throws SQLException {
		
		Stm = conn.createStatement(this.type, this.mode);
		
		String q = "SELECT quantite FROM LesStocks  "
				+ "WHERE refrce='"+ref+"'";

		rs = Stm.executeQuery(q);
		rs.next();
		int qteRestante = rs.getInt("quantite") - qte; 
		
		return qteRestante;
	}
	
	public int getPrix(String ref) throws SQLException {
		
		Stm = conn.createStatement(this.type, this.mode);
		
		String q = "SELECT prix FROM LesCatalogues  "
				+ "WHERE refrce='"+ref+"'";

		rs = Stm.executeQuery(q);
		rs.next();
		int qteRestante = rs.getInt("prix"); 
		
		return qteRestante;
	}
	
//	public int getNouveauIDCommande() {
//		String newId = "SELECT MAX(IDcommande)+1 AS IDcommande FROM LesCommandes";
//		Statement Stm = conn.createStatement();
//		ResultSet rs = Stm.executeQuery(newId); 
//		rs.next();
//		int id = rs.getInt("IDcommande");
//		
//		String ajout = "INSERT INTO LesCommandes(IDcommande,IDclient,DateCommande,"+
//						"prixTOTAL,statut) "+
//						String.format();
//		
//		Stm.executeUpdate(ajout);
//	}
	
public void creationCadre() throws SQLException {
        
        String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

        rs = Stm.executeQuery(newImprId);
        rs.next();

        int id_imp = rs.getInt("IDimpress");
        impressionDAO.create(new Impression(id_imp, id_client));
        
        
        String refCadres = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
                + "LesStocks WHERE SUPPORT='cadre' AND QUANTITE > 0 ";

        rs = Stm.executeQuery(refCadres);
        System.out.println("\nLes references de cadre dans le catalogue (et disponible en stock): ");

        while (rs.next()) {
            System.out.println(rs.getString("REFRCE"));
        }
        
        print("\nEntrer une reference d'album a partir du catalogue: \n");

		String ref = LectureClavier.lireChaine();
        
        Cadre cad = new Cadre(id_imp, ref);
        cadreDAO.create(cad);
        print("\nLa cadre a ete cree.\n");
    }

public void creationCalendrier() throws SQLException {
    
    String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

    rs = Stm.executeQuery(newImprId);
    rs.next();

    int id_imp = rs.getInt("IDimpress");
    impressionDAO.create(new Impression(id_imp, id_client));
    
    
    String ref = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
            + "LesStocks WHERE SUPPORT='calendrier' AND QUANTITE > 0 ";

    rs = Stm.executeQuery(ref);
    System.out.println("\nLes references de calendrier dans le catalogue (et disponible en stock): ");

    while (rs.next()) {
        System.out.println(rs.getString("REFRCE"));
    }
    
    print("\nEntrer une reference d'album a partir du catalogue: \n");

	String refe = LectureClavier.lireChaine();

    Calendrier cal = new Calendrier(id_imp, refe);
    calendrierDAO.create(cal);
    print("\nLa calendrier a ete cree.\n");
}

//public void creationTirage() throws SQLException {
//    
//    String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";
//
//    rs = Stm.executeQuery(newImprId);
//    rs.next();
//
//    int id_imp = rs.getInt("IDimpress");
//    impressionDAO.create(new Impression(id_imp, id_client));
//    
//    
//    String refTirage = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
//            + "LesStocks WHERE SUPPORT='papier' AND QUANTITE > 0 ";
//
//    rs = Stm.executeQuery(refTirage);
//    System.out.println("\nLes references de papier dans le catalogue (et disponible en stock): ");
//
//    while (rs.next()) {
//        System.out.println(rs.getString("REFRCE"));
//    }
//
//
//    print("\nEntrer une reference d'album a partir du catalogue: \n");
//
//	String refe = LectureClavier.lireChaine();
//
//    TiragePhoto pap = new TiragePhoto(id_imp, ref);
//    pap.create();
//    print("\nLe Tirage a ete cree.\n");
}
	

