package projet;

public class Client {
	private int idclient;
	private String email;
	private String nom;
	private String prenom;
	private String mdp;
	
	public Client(int idclient, String email, String nom, String prenom, String mdp) {
		this.idclient = idclient;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
	}

	public int getIDclient() {
		return idclient;
	}

	public void setIDclient(int idclient) {
		this.idclient = idclient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
