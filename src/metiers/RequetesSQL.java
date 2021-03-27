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
import dao.PhotoDAO;
import dao.TiragePhotoDAO;

public class RequetesSQL extends ConnectionClient {

	private int id_client;
	ClientDAO clientDAO = new ClientDAO(conn);
	FichierImageDAO fichierDAO = new FichierImageDAO(conn);
	AlbumDAO albumDAO = new AlbumDAO(conn);
	ImpressionDAO impressionDAO = new ImpressionDAO(this.conn);
	CadreDAO cadreDAO = new CadreDAO(this.conn);
	CalendrierDAO calendrierDAO = new CalendrierDAO(this.conn);
	TiragePhotoDAO tirageDAO = new TiragePhotoDAO(this.conn);
	AdresseDAO adresseDAO = new AdresseDAO(this.conn);
	PhotoDAO photoDAO = new PhotoDAO(this.conn);

	Statement statement;
	ResultSet result;

	public RequetesSQL(Connection conn, int id_client) {
		super(conn);
		this.id_client = id_client;
	}

	public void print(String s) {
		System.out.print(s);
	}

	public void voirCollectionImages() {
		/*
		 * avec l'ID du client on obtient les cheminAcces avec lesquels on pourra voir
		 * les images du client
		 */
		Client client = clientDAO.read(id_client);
		client.printListeFichiersImages();
	}

	public void voirImpression() throws SQLException {
		
		Statement statement = conn.createStatement(this.type,this.mode);

		ResultSet result = statement.executeQuery("select * from LesImpressions " +
						"where IDclient="+id_client
		);

		
		while (result.next()) {
			Album alb = albumDAO.read(result.getInt("IDimpress"));
			Cadre cadre = cadreDAO.read(result.getInt("IDimpress"));
			Calendrier calendrier = calendrierDAO.read(result.getInt("IDimpress"));
			TiragePhoto tirage = tirageDAO.read(result.getInt("IDimpress"));

			if (alb.getId_impression() != 0) {
				
				System.out.print(alb);
				System.out.println("Prix: "+getPrix(alb.getReference())+" euros\n");
			} if (cadre.getId_impression() != 0) {
				
				System.out.print(cadre);
				System.out.println("Prix: "+getPrix(cadre.getReference())+" euros\n");
			} if (calendrier.getId_impression() != 0) {
				System.out.print(calendrier);
				System.out.println("Prix: "+getPrix(calendrier.getReference())+" euros\n");

			} if(tirage.getIDimpress() != 0) {
				System.out.print(tirage);
				System.out.println("Prix: "+getPrix(tirage.getReference())+" euros");
			}
		}
		result.beforeFirst();
		if(!result.next()){
			System.out.println("Vous n'avez pas creer d'impressions.");
		}
		
	}

	public void creationAlbum() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

		ResultSet result = statement.executeQuery(newImprId);
		result.next();

		int id_imp = result.getInt("IDimpress");
		impressionDAO.create(new Impression(id_imp, id_client));

		String refAlbums = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
				+ "LesStocks WHERE SUPPORT='album' AND QUANTITE > 0 ";

		result = statement.executeQuery(refAlbums);
		System.out.println("\nLes references d'albums dans le catalogue (et disponible en stock): ");

		while (result.next()) {
			System.out.println(result.getString("REFRCE"));
		}

		print("\nEntrer une reference d'album a partir du catalogue: \n");

		String ref = LectureClavier.lireChaine();
		print("Donnez un titre a l'album: ");
		String titre = LectureClavier.lireChaine();

		String pagesCouverturesPossible = "SELECT IDpage FROM " + "LesPages NATURAL JOIN LesAlbums";

		result = statement.executeQuery(pagesCouverturesPossible);
		System.out.println("\nLes pages disponibles comme couverture pour les albums: ");

		while (result.next()) {
			System.out.println(result.getInt("IDpage"));
		}

		int pageCouv = LectureClavier.lireEntier("\nChoisissez une page de couverture");

		Album alb = new Album(id_imp, ref, titre, pageCouv);
		albumDAO.create(alb);
		print("\nL'album a ete cree.\n");
	}

	public void voirCommandes() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String commandes = "SELECT * FROM LesCommandes " + "WHERE IDclient=" + id_client;

		ResultSet result = statement.executeQuery(commandes);
		result.beforeFirst();

		ResultSetMetaData resultmd = result.getMetaData();
		int columnsNumber = resultmd.getColumnCount();

		for (int i = 1; i <= columnsNumber; i++) {
			if (i == 2) {
				continue;
			}
			System.out.print(resultmd.getColumnName(i) + " ");

		}
		
		System.out.println("");

		while (result.next()) {
			System.out.println("\n      " + result.getInt("IDcommande") + "    " + result.getDate("DateCommande") + "     "
					+ result.getFloat("prixTOTAL") + "      " + result.getString("statut"));
		}

		result.beforeFirst();
		if(!result.first()){
			System.out.println("Vous n'avez rien commander.\n");
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
		Statement statement = conn.createStatement(this.type, this.mode);
		ResultSet result = statement.executeQuery(newAdrId);
		result.next();
		int idAdr = result.getInt("IDadresse");

		Adresse adr = new Adresse(idAdr, num, rue, ville, codepostal, id_client);
		client.addAdresse(adr);
		adresseDAO.create(adr);
		System.out.println("\nL'Adresse a ete ajoute.");
	}

	public void voirImagesPartages() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String fichiersPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=1";

		ResultSet result = statement.executeQuery(fichiersPartages);
		result.beforeFirst();

		print("\n");

		while (result.next()) {
			System.out.println(result.getString("CheminAcces"));
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
		statement = conn.createStatement(this.type, this.mode);
		String fichiersNonPartages = "SELECT * FROM LesFichiersImages WHERE estPartage=0";

		ResultSet result = statement.executeQuery(fichiersNonPartages);
		result.beforeFirst();

		print("\n");
		print("Vos fichiers images non partages sont:\n\n");

		while (result.next()) {
			System.out.println(result.getString("CheminAcces"));
		}

		print("\nQuel image voulez vous partager ? (indiquez le chemin d'acces) ->");
		String imgAPartager = LectureClavier.lireChaine();

		FichierImage fi = fichierDAO.read(imgAPartager);
		fi.setEst_partage(1);
		fichierDAO.update(fi);
		print("\nLe fichier " + fi.getChemin_acces() + " est maintenant partage.\n");
	}

	public void supprimerImage() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String fichiersImages = "SELECT CheminAcces FROM LesFichiersImages " + 
								"WHERE IDclient=" + id_client;

		ResultSet result = statement.executeQuery(fichiersImages);
		result.beforeFirst();

		print("\n");
		print("Vos fichiers images sont:\n\n");

		while (result.next()) {
			System.out.println(result.getString("CheminAcces"));
		}

		print("\nQuel image voulez vous supprimez ? (indiquez le chemin d'acces) ->");
		String imgASup = LectureClavier.lireChaine();

		Photo photoASup = photoDAO.read(imgASup);
		photoDAO.delete(photoASup);

		FichierImage fiASup = fichierDAO.read(imgASup);
		fichierDAO.delete(fiASup);
		print("\nLe fichier " + fiASup.getChemin_acces() + " a ete supprime.\n");
	}

	public int getQteRestante(String ref, int qte) throws SQLException {

		Statement statement = conn.createStatement(this.type, this.mode);

		String q = "SELECT quantite FROM LesStocks WHERE refrce='" + ref + "'";

		ResultSet result = statement.executeQuery(q);
		result.next();
		int qteRestante = result.getInt("quantite") - qte;

		return qteRestante;
	}

	public int getPrix(String ref) throws SQLException {

		Statement statement = conn.createStatement(this.type, this.mode);

		String q = "SELECT prix FROM LesCatalogues  " + "WHERE refrce='" + ref + "'";

		ResultSet result = statement.executeQuery(q);
		result.next();
		int qteRestante = result.getInt("prix");

		return qteRestante;
	}

	public int getNouveauIDCommande() throws SQLException {
		String newId = "SELECT MAX(IDcommande)+1 AS IDcommande FROM LesCommandes";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(newId);
		result.next();
		int id = result.getInt("IDcommande");

		return id;
	}

	public void creationCadre() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

		ResultSet result = statement.executeQuery(newImprId);
		result.next();
		
		int id_imp = result.getInt("IDimpress");


		impressionDAO.create(new Impression(id_imp, id_client));

		String refCadres = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
				+ "LesStocks WHERE SUPPORT='cadre' AND QUANTITE > 0 ";

		result = statement.executeQuery(refCadres);
		System.out.println("\nLes references de cadre dans le catalogue (et disponible en stock): ");

		while (result.next()) {
			System.out.println(result.getString("REFRCE"));
		}

		print("\nEntrer une reference de cadre a partir du catalogue: \n");

		String ref = LectureClavier.lireChaine();

		Cadre cad = new Cadre(id_imp, ref);
		cadreDAO.create(cad);
		print("\nLa cadre a ete cree.\n");
	}

	public void creationCalendrier() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

		ResultSet result = statement.executeQuery(newImprId);
		result.next();

		int id_imp = result.getInt("IDimpress");
		impressionDAO.create(new Impression(id_imp, id_client));

		String ref = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
				+ "LesStocks WHERE SUPPORT='calendrier' AND QUANTITE > 0 ";

		result = statement.executeQuery(ref);
		System.out.println("\nLes references de calendrier dans le catalogue (et disponible en stock): ");

		while (result.next()) {
			System.out.println(result.getString("REFRCE"));
		}

		print("\nEntrer une reference d'album a partir du catalogue: \n");

		String refe = LectureClavier.lireChaine();

		Calendrier cal = new Calendrier(id_imp, refe);
		calendrierDAO.create(cal);
		print("\nLa calendrier a ete cree.\n");
	}

	public void creationTirage() throws SQLException {
		Statement statement = conn.createStatement(this.type, this.mode);
		String newImprId = "SELECT MAX(IDimpress)+1 AS IDimpress FROM LesImpressions";

		ResultSet result = statement.executeQuery(newImprId);
		result.next();

		int id_imp = result.getInt("IDimpress");
		impressionDAO.create(new Impression(id_imp, id_client));

		String q = "SELECT REFRCE FROM LesCatalogues NATURAL JOIN "
				+ "LesStocks WHERE SUPPORT='papier' AND QUANTITE > 0 ";

		result = statement.executeQuery(q);
		System.out.println("\nLes references de papier dans le catalogue (et disponible en stock): ");

		while (result.next()) {
			System.out.println(result.getString("REFRCE"));
		}

		print("\nEntrer une reference de tirage a partir du catalogue: \n");

		String refTirage = LectureClavier.lireChaine();
		print("\nEntrer un chemin d'acces: \n");
		String chemin = LectureClavier.lireChaine();
		print("\nEntrer des parametres : \n");
		String param = LectureClavier.lireChaine();
		int nb = LectureClavier.lireEntier("\nEntrer le nombre d'exemplaire: \n");

		TiragePhoto tir = new TiragePhoto(id_imp, refTirage, chemin, param, nb);
		tirageDAO.create(tir);
		print("\nLe Tirage photo a ete cree.\n");
	}

}
