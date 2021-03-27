package metiers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import dao.*;

public class MenuPrincipale extends ConnectionClient {
	private int id_client;
	RequetesSQL sql;

	public MenuPrincipale(Connection conn, int id_client) {
		super(conn);
		this.id_client = id_client;
		sql = new RequetesSQL(conn, id_client);
	}

	public void print(String s) {
		System.out.print(s);
	}

	public void printMenu(String s) {
		System.out.print("\n-------------- " + s + " --------------\n\n");
	}

	public void clear() {
		int i = 0;
		while (i < 50) {
			System.out.println();
			i++;
		}
	}

	public int menuSelector(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				printMenu(args[i]);
			} else {
				System.out.print(args[i] + "\n");
			}
		}
		return userInputNumber(args.length);
	}

	public int userInputNumber(int length) {
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
		} while (n == null || !(n > 0 && n < length));
		return n;
	}

	public void menuPrincipal() throws SQLException {
		String[] myMenu = { "MENU PRINCIPAL", "1.Gestion des Images", "2.Gestion des Impressions",
				"3.Gestion des Commandes", "4.Profil et adresses" };

		switch (menuSelector(myMenu)) {
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

	public void menuImages() throws SQLException {
		String[] imagesMenu = { "MENU / GESTION DE MES IMAGES", "1.voir ma collection d'images",
				"2.voir les images issus de partages", "3.telecharger(upload) une image",
				"4.Ajouter une image partagee", "5.partager une image perso", "6.supprimer une image", "7.retour" };

		switch (menuSelector(imagesMenu)) {
		case 1:

			sql.voirCollectionImages();

			menuImages();
			break;

		case 2:
			sql.voirImagesPartages();

			menuImages();
			break;

		case 3:
			sql.telechargerImage();

			menuImages();
			break;

		case 4:

			// TODO
			print("nom implementée");
			menuImages();
			break;

		case 5:
			sql.partagerImagePerso();

			menuImages();
			break;

		case 6:
			sql.supprimerImage();

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

	public void menuImpressions() throws SQLException {
		String[] impressionMenu = { "MENU / GESTION DE MES IMPRESSIONS", "1.voir mes impressions", "2.creer",
				"3.retour" };

		switch (menuSelector(impressionMenu)) {
		case 1:
			sql.voirImpression();

			menuImpressions();
			break;

		case 2:
			clear();
			String[] impressionTypeMenu = { "MENU / GESTION DE MES IMPRESSIONS / NOUVELLE IMPRESSION / TYPE ???",
					"1. Tirage photo", "2. Calendrier", "3. Album", "4. Cadre", "5. Retour" };

			switch (menuSelector(impressionTypeMenu)) {
			case 1:
				sql.creationTirage();
				print("nom implementée");
				menuImpressions();
				break;
			case 2:
				// TODO
				sql.creationCalendrier();
				menuImpressions();
				break;

			case 3:
				sql.creationAlbum();

				menuImpressions();
				break;
			case 4:
				// TODO
				sql.creationCadre();
				menuImpressions();
				break;
			case 5:

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

	public void menuCommandes() throws SQLException {

		String[] cmdMenu = { "MENU / GESTION DE MES COMMANDES", "1.voir mes commandes",
				"2.passer une nouvelle commande", "3.retour" };

		switch (menuSelector(cmdMenu)) {

		case 1:
			sql.voirCommandes();

			print("\n");

			menuCommandes();
			break;

		case 2:
			clear();
			StockDAO stockDAO = new StockDAO(this.conn);
			CommandeDAO commandeDAO = new CommandeDAO(this.conn);
			printMenu("MENU / GESTION DE MES COMMANDES / NOUVELLE COMMANDES");
			boolean encore = true;
			int prixTot = 0;
			while (encore) {
				
				System.out.println("Vos impressions creees: \n");
				sql.voirImpression();
				System.out.println("Choisissez une impression (par reference)\n");
				String ref = LectureClavier.lireChaine();
				int qte = LectureClavier.lireEntier("Combien d'exemplaire voulez-vous?");
				int qteRestante = sql.getQteRestante(ref, qte);
				Stock stock = stockDAO.read(ref);
				stock.setQuantite(qteRestante);
				stockDAO.update(stock);
				
				
				// lire prix du catalogue 
				int prix = sql.getPrix(ref);
				// le multiplier par quantite
				prixTot = prixTot + prix * qte;
				// creer une commande avec ces attributs
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				int idcmd = sql.getNouveauIDCommande();
				Commande cmd = new Commande(idcmd,id_client,date,prixTot,"En cours");
				commandeDAO.create(cmd);
			
				

				print("\n");
				String[] cmdEncore = { "ajouter encore des Article a cette commande ?", "1.oui, encore !",
						"2.non merci" };
				if (menuSelector(cmdEncore) == 2) {
					encore = false;
				}
			}
			print("\nPrix de la commande: "+prixTot+" euros\n");
			print("\nSaisissez un mode de paiement :");
			LectureClavier.lireChaine();

			print("\n\nPaiement effectue ! RETOUR au menu precedant...\n");
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

	public void menuProfil() throws SQLException {

		String[] cmdMenu = { "MENU / PROFIL & ADRESSES", "1.voir", "2.ajouter une adresse", "3.retour" };

		switch (menuSelector(cmdMenu)) {
		case 1:
			sql.voirProfile();

			menuProfil();
			break;
		case 2:

			printMenu("ajout d'une adresse");

			sql.ajouterAdresse();

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