package metiers;

public class Calendrier {

	private int id_impression;
	private String reference;

	public Calendrier(int id_impression, String reference) {
		this.id_impression = id_impression;
		this.reference = reference;
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

}
