package metiers;

public class Album {
	private int id_impression;
	private String reference;
	private String titre;
	private int couverture;
	
	
	public Album() {}


	public Album(int id_impression, String reference, String titre, int couverture) {
		super();
		this.id_impression = id_impression;
		this.reference = reference;
		this.titre = titre;
		this.couverture = couverture;
	}


	public int getId_impression() {
		return id_impression;
	}


	public void setId_impression(int id_impression) {
		this.id_impression = id_impression;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getCouverture() {
		return couverture;
	}


	public void setCouverture(int couverture) {
		this.couverture = couverture;
	}
	
	

}
