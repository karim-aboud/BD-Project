package metiers;

public class Adresse {
	private int id_adresse;
	private int num_rue;
	private String nom_rue;
	private String ville;
	private int code_postal;
	private int id_client; //ID client
	
	public Adresse() {}
	
	public Adresse (int id_adresse, int numRue, String nomRue,String ville,int codePostal,int id_client) {
		this.id_adresse = id_adresse;
		this.num_rue = numRue;
		this.nom_rue = nomRue;
		this.ville = ville;
		this.code_postal = codePostal;
		this.id_client=id_client;
	}

	public int getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(int id_adresse) {
		this.id_adresse = id_adresse;
	}

	public int getIdClient() {
		return id_client;
	}

	public void setIdClient(int id_client) {
		this.id_client = id_client;
	}

	public int getNumRue() {
		return num_rue;
	}

	public void setNumRue(int numRue) {
		this.num_rue = numRue;
	}

	public String getNomRue() {
		return nom_rue;
	}

	public void setNomRue(String nomRue) {
		this.nom_rue = nomRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return code_postal;
	}

	public void setCodePostal(int codePostal) {
		this.code_postal = codePostal;
	}

	@Override
	public String toString() {
		return num_rue +" "+ nom_rue +" "+ code_postal+" "+ville ;
	}
		
	
}