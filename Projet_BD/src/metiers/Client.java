package metiers;

import java.util.HashSet;
import java.util.Set;

public class Client {

	private int id_client;
	private String adr_mail;
	private String nom;
	private String prenom;
	private String mot_de_passe;
	private Adresse adresse;
	private Set<FichierImage> listeFichiersImages = new HashSet<FichierImage>();
	private Set<Commande> listeCommandes = new HashSet<Commande>();
	
	public Client() {}

	public Client(int id,String adr_mail,String nom,String prenom,String mot_de_passe) {
		this.id_client = id;
		this.adr_mail = adr_mail;
		this.nom = nom;
		this.prenom = prenom;
		this.mot_de_passe = mot_de_passe;

	}

	public int getIdClient() {
		return id_client;
	}

	public void setIdClient(int id_client) {
		this.id_client = id_client;
	}

	public String getAdrMail() {
		return adr_mail;
	}

	public void setAdrMail(String adr_mail) {
		this.adr_mail = adr_mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return mot_de_passe;
	}

	public void setMotDePasse(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	public Adresse getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse( Adresse a) {
		this.adresse = a;
		
	}

	public Set<FichierImage> getListeFichiersImages() {
		return listeFichiersImages;
	}

	public void setListeFichiersImages(Set<FichierImage> listeFichiersImages) {
		this.listeFichiersImages = listeFichiersImages;
	}
	
	public void addFichierImage(FichierImage fichier) {
		listeFichiersImages.add(fichier);
	}
	
	public void removeFichierImage(FichierImage fichier) {
		listeFichiersImages.remove(fichier);
	}
	
	public String getFichiersImagesAsString() {
		
		String res="";
		
		for( FichierImage fichier : listeFichiersImages ){
            res+=fichier.toString();
        }
		return res;
	}
	
	public void printListeFichiersImages() {
		
		for( FichierImage fichier : listeFichiersImages ){
            System.out.println(fichier.toString());
        }
	}

	public Set<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(Set<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}
	
	public String displayCommandes() {
		
		String res="";
		
		for( Commande cmd : listeCommandes ){
            res+=cmd.toString();
        }
		return res;
	}
	
	public void addCommande(Commande commande) {
		listeCommandes.add(commande);
	}
	

	public void removeCommande(Commande commande) {
		listeCommandes.remove(commande);
	}
	
	@Override
	public String toString() {
		return "Client [id = "+id_client+"]:\n"+
				"---------------------------\n"+
				"Mail: "+adr_mail+"\n"+
				"Nom: "+nom+"\n"+
				"Prenom: "+prenom+"\n"+
				"Adresse: "+adresse+"\n\n"+
				"Fichier images: "+getFichiersImagesAsString()+"\n\n"+
				"Commandes: "+displayCommandes()+"\n\n" 
				+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}
	
}
