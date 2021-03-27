package metiers;
import java.sql.Date;

public class FichierImage {

	private String chemin_acces;
	private int id_client;
	private Date date_creation;
	private String info_prise_de_vue;
	private int resolution_img;
	private int est_partage; // 0 = faux | 1 = vrai
	private Photo photo;

	public FichierImage() {}
	
	public FichierImage(String chemin_acces,int id_client, Date date_creation, String info_prise_de_vue,
			int resolution_img, int est_partage) {

		this.id_client = id_client;
		this.chemin_acces = chemin_acces;
		this.date_creation = date_creation;
		this.info_prise_de_vue = info_prise_de_vue;
		this.resolution_img = resolution_img;
		this.est_partage = est_partage;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getChemin_acces() {
		return chemin_acces;
	}

	public void setChemin_acces(String chemin_acces) {
		this.chemin_acces = chemin_acces;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getInfo_prise_vue() {
		return info_prise_de_vue;
	}

	public void setInfo_prise_vue(String info_prise_de_vue) {
		this.info_prise_de_vue = info_prise_de_vue;
	}

	public int getResolution_img() {
		return resolution_img;
	}

	public void setResolution_img(int resolution_img) {
		this.resolution_img = resolution_img;
	}

	public int getEst_partage() {
		return est_partage;
	}

	public void setEst_partage(int est_partage) {
		this.est_partage = est_partage;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "\n------------------- Fichier image crée le "+ date_creation+" --------------------\n"+
				"Chemin d'acces: "+chemin_acces+"\n"+
				"Resolution: "+resolution_img+"\n"+
				"Est partage: "+est_partage+"\n"+
				"Info:"+info_prise_de_vue+"\n"+
				"ID client: "+id_client+"\n\n"+
				"Photo: "+photo+"\n";
	}

}
