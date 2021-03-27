package metiers;

public class Page {
	
	private int IDpage; // un numero de page (peut contenir plusieur photos)
	private int IDimpress;
	private int noPage;
	private String miseEnForme;
	
	public Page() {}
	
	public Page(int iDpage, int iDimpress, int noPage, String miseEnForme) {
		IDpage = iDpage;
		IDimpress = iDimpress;
		this.noPage = noPage;
		this.miseEnForme = miseEnForme;
	}

	public int getIDpage() {
		return IDpage;
	}

	public void setIDpage(int iDpage) {
		IDpage = iDpage;
	}

	public int getIDimpress() {
		return IDimpress;
	}

	public void setIDimpress(int iDimpress) {
		IDimpress = iDimpress;
	}

	public int getNoPage() {
		return noPage;
	}

	public void setNoPage(int noPage) {
		this.noPage = noPage;
	}

	public String getMiseEnForme() {
		return miseEnForme;
	}

	public void setMiseEnForme(String miseEnForme) {
		this.miseEnForme = miseEnForme;
	}
	
}