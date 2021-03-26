package metiers;

public class Promotion {

	private String code_promo;
	private int reduction;
	private int id_commande;

	public Promotion(String code_promo, int reduction, int id_commande) {
		this.code_promo = code_promo;
		this.reduction = reduction;
		this.id_commande = id_commande;
	}

	public String getCode_promo() {
		return code_promo;
	}

	public void setCode_promo(String code_promo) {
		this.code_promo = code_promo;
	}

	public int getReduction() {
		return reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

}
