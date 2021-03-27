package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Article;
import metiers.Client;

public class ArticleDAO extends DAO<Article> {

	public ArticleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Article obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesArticles(IDimpress,IDcommande,refrce,quantite,prix) "+
					"values(?,?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getId_impression());
			prepare.setInt(2, obj.getId_commande());
			prepare.setString(3, obj.getReference());
			prepare.setInt(4, obj.getQuantite());
			prepare.setFloat(5, obj.getPrix_impression());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Article read(int id) {
		
		Article article = new Article();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesArticles " +
						"WHERE IDimpress=" + id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				article = new Article(id,rs.getInt("IDcommande"),rs.getString("refrce"),
						rs.getInt("quantite"),rs.getFloat("prix"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return article;
	}

	@Override
	public boolean update(Article obj) {

		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesArticles set refrce=?, quantite=?, "+
					"prix=? where IDimpress="+obj.getId_impression());

			prepare.setString(1, obj.getReference());
			prepare.setInt(2,obj.getQuantite());
			prepare.setFloat(3, obj.getPrix_impression());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Article obj) {

		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supArticle = "delete from LesArticles where IDimpress="+obj.getId_impression();
			myStm.executeUpdate(supArticle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
