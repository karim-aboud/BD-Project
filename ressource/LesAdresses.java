package projet;

public class LesAdresses {
	private int idClient; //ID client
	int numRue;
	String nomRue;
	String ville;
	int codePostal;
	
	public LesAdresses(int idClient, int numRue, String nomRue, String ville, int codePostal) {
		this.idClient = idClient;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
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
