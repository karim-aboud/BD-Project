package metiers;

public class Article {
	private int id_impression;
	private int id_commande;
	private String reference;
	private float prix;
	private int quantite;
	
	
	public Article() {}

	public Article(int id_impression,int id_commande, String reference, int quantite,float prix ) {
		this.id_impression = id_impression;
		this.id_commande = id_commande;
		this.setReference(reference);
		this.prix = prix;
		this.quantite = quantite;
	}


	public int getId_impression() {
		return id_impression;
	}

	public void setId_impression(int id_impression) {
		this.id_impression = id_impression;
	}

	public float getPrix_impression() {
		return prix;
	}

	public void setPrix_impression(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getId_commande() {
		return id_commande;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	public String toString() {
		return "\n------------------- Article [id = "+ id_impression+"] --------------------\n"+
				"Prix impression: "+prix+" €\n"+
				"Quantite: "+quantite+"\n";
	}
	
}
