package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import metiers.Commande;

public class CommandeDAO extends DAO<Commande> {

	public CommandeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesCommandes(IDcommande,IDclient,DateCommande,prixTOTAL,statut)"+
					"values(?,?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getId_commande());
			prepare.setInt(2, obj.getId_client());
			prepare.setDate(3, obj.getDate_commande());
			prepare.setFloat(4, obj.getPrix_total());
			prepare.setString(5, obj.getStatut());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Commande read(int id) {
		
		Commande commande = new Commande();
		ArticleDAO articleDAO = new ArticleDAO(this.connect);
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesCommandes " +
						"NATURAL LEFT JOIN LesArticles "+
						"NATURAL LEFT JOIN LesPromotions WHERE IDcommande=" + id;
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				commande = new Commande(id,rs.getInt("IDclient"),rs.getDate("DateCommande"),
						rs.getFloat("prixTOTAL"), rs.getString("statut"));
				
			}
			
			rs.beforeFirst();
			 
			
			while(rs.next()) {
				// Articles
				commande.addArticle(articleDAO.read(rs.getInt("IDimpress")));
				//Promotions
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commande;
	}

	@Override
	public boolean update(Commande obj) {
		
		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesCommandes set IDclient=?, DateCommande=?, "+
					"prix=?, statut=? where IDcommande="+obj.getId_commande() );

			prepare.setInt(1, obj.getId_client());
			prepare.setDate(2,obj.getDate_commande());
			prepare.setFloat(3, obj.getPrix_total());
			prepare.setString(4, obj.getStatut());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Commande obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supCommande = "delete from LesCommandes where IDcommande="+obj.getId_commande();
			myStm.executeUpdate(supCommande);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
