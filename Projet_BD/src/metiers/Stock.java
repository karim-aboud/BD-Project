package metiers;

public class Stock {
	
	private String reference;
	private int quantite;
	
	
	public Stock(String reference, int quantite) {
		this.reference = reference;
		this.quantite = quantite;
	}

	
	public Stock() {}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
	
	
}
