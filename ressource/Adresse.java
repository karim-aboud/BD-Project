package projet;

public class Adresse {
	private int noRue;
	private String nomRue;
	private String ville;
	private int codePostal;
	private int idClient; //ID client
	
	public Adresse(int noRue, String nomRue, String ville, int codePostal, int idClient) {
		this.noRue = noRue;
		this.nomRue = nomRue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.idClient = idClient;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getNoRue() {
		return noRue;
	}

	public void setNoRue(int noRue) {
		this.noRue = noRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	

	//insert 
	
	
}
