package metiers;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Commande {
	private int id_commande;
	private Date date_commande;
	private float prix_total;
	private String statut;
	private int id_client;
	private Set<Article> listeArticles = new HashSet<Article>();
	private Set<Promotion> listePromotions = new HashSet<Promotion>();
	
	public Commande() {}
	
	public Commande(int prix, int id_client) {
		this.prix_total=prix;
		this.id_client = id_client;
	}
	
	public Commande(int id_commande,int id_client,Date date_commande, float prix_total, String statut) {
		this.id_commande = id_commande;
		this.date_commande = date_commande;
		this.prix_total = prix_total;
		this.statut = statut;
		this.id_client = id_client;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public float getPrix_total() {
		return prix_total;
	}

	public void setPrix_total(float prix_total) {
		this.prix_total = prix_total;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public Set getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(Set articles) {
		this.listeArticles = articles;
	}
	
	public void addArticle(Article article) {
		this.listeArticles.add(article);
	}
	
	public void removeArticle(Article article) {
		this.listeArticles.remove(article);
	}
	
	public String displayArticles() {
		String res="";
		for(Article a: listeArticles) {
			res+=a.toString();
		}
		return res;
	}
	
	public Set<Promotion> getPromotions() {
		return this.listePromotions;
	}

	public void setPromotions(Set<Promotion>promotions) {
		this.listePromotions = promotions;
	}
	
	public void addPromotion(Promotion promo) {
		this.listePromotions.add(promo);
	}
	
	public void removePromotion(Promotion promo) {
		this.listePromotions.remove(promo);
	}

	@Override
	public String toString() {
		return "\n~~~~~~~~~~~~~~~~~~ Commande [id = "+ id_commande+"] ~~~~~~~~~~~~~~~~~~~\n"+
				"Date commande: "+date_commande+"\n"+
				"\nArticles: "+displayArticles()+"\n\n"+
				"Prix total commande: "+prix_total+" €\n"+
				"Statut: "+statut+"\n"+
				"ID client: "+id_client+"\n";

	}
}
