package metiers;

public class Impression {
	protected int id_impression;
	private int id_client;	
	
	public Impression() {}
	
	public Impression(int id_impression, int id_client) {
		this.id_impression = id_impression;
		this.id_client = id_client;
	}

	

	public int getId_impression() {
		return id_impression;
	}

	public void setId_impression(int id_impression) {
		this.id_impression = id_impression;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

}
