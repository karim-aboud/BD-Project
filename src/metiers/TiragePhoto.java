package metiers;

public class TiragePhoto  {
	
	private int IDimpress;
	private String reference;
	private String cheminAcces;
	private String parametres;
	private int nbExemplaire;
	
	public TiragePhoto () {}
	
	public TiragePhoto(int iDimpress, String reference, String cheminAcces, String parametres, int nbExemplaire) {
		
		IDimpress = iDimpress;
		this.reference = reference;
		this.cheminAcces = cheminAcces;
		this.parametres = parametres;
		this.nbExemplaire = nbExemplaire;
	}

	public int getIDimpress() {
		return IDimpress;
	}

	public void setIDimpress(int iDimpress) {
		IDimpress = iDimpress;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCheminAcces() {
		return cheminAcces;
	}

	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}

	public String getParametres() {
		return parametres;
	}

	public void setParametres(String parametres) {
		this.parametres = parametres;
	}

	public int getNbExemplaire() {
		return nbExemplaire;
	}

	public void setNbExemplaire(int nbExemplaire) {
		this.nbExemplaire = nbExemplaire;
	}
	
	public String toString() {
		return "Tirage photo [id = "+IDimpress+" ]"+"\n"+
				"Reference: "+reference+"\n"+
				"Chemin d'acces: "+cheminAcces+"\n"+
				"parametres: "+parametres+"\n"+
				"Nombre d'exemplaire: "+nbExemplaire+"\n";
	}
	
}
