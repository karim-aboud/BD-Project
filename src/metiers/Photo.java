package metiers;

public class Photo {
	private int id_photo;
	private int id_page;
	private String chemin_acces;
	private String parametres;
	private String text_descriptif;
	
	public Photo() {}
	
	public Photo(int id_photo, int id_page, String chemin_acces, String parametres, String text_descriptif) {
		this.id_photo = id_photo;
		this.id_page = id_page;
		this.chemin_acces = chemin_acces;
		this.parametres = parametres;
		this.text_descriptif = text_descriptif;
	}

	
	public int getId_photo() {
		return id_photo;
	}

	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}
	
	
	public int getId_page() {
		return id_page;
	}

	public void setId_page(int id_page) {
		this.id_page = id_page;
	}

	public String getChemin_acces() {
		return chemin_acces;
	}

	public void setChemin_acces(String chemin_acces) {
		this.chemin_acces = chemin_acces;
	}

	public String getParametres() {
		return parametres;
	}

	public void setParametres(String parametres) {
		this.parametres = parametres;
	}

	public String getText_descriptif() {
		return text_descriptif;
	}

	public void setText_descriptif(String text_descriptif) {
		this.text_descriptif = text_descriptif;
	}

	public String toString() {
			return	"Photo [id = "+id_photo+"]:\n"+
					"ID page: "+id_page+"\n"+
					"Chemin d'acces: "+chemin_acces+"\n"+
					"Parametres: "+parametres+"\n"+
					"Text descriptif: "+text_descriptif+"\n";
	}

	
	
}
