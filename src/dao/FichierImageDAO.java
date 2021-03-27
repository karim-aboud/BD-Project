package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Commande;
import metiers.FichierImage;

public class FichierImageDAO extends DAO<FichierImage> {
	
	
	public FichierImageDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(FichierImage obj) {
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesFichiersImages(CheminAcces,IDclient,DateCreation,"+
					"InfoPriseVue,Resolution,estPartage) "+
					"values(?,?,?,?,?,?)"
					);
			
			prepare.setString(1, obj.getChemin_acces());
			prepare.setInt(2,obj.getId_client());
			prepare.setDate(3, obj.getDate_creation());
			prepare.setString(4, obj.getInfo_prise_vue());
			prepare.setInt(5, obj.getResolution_img());
			prepare.setInt(6, obj.getEst_partage());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}
	
	
	@Override
	public FichierImage read(int id) {return null;}
	
	public FichierImage read(String chemin) {
		
		FichierImage fichier = new FichierImage();
		PhotoDAO photoDAO= new PhotoDAO(this.connect);
		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesFichiersImages NATURAL LEFT JOIN LesPhotos"
					+ " WHERE CheminAcces='" +chemin+"'";
								
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				fichier = new FichierImage(chemin,rs.getInt("IDclient"),rs.getDate("DateCreation"),
						rs.getString("InfoPriseVue"),rs.getInt("Resolution"),
						rs.getInt("estPartage"));
				
				fichier.setPhoto(photoDAO.read(rs.getInt("IDphoto")));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fichier;
	}
	
	@Override
	public boolean update(FichierImage obj) {
		
		int upd = 0;
		
		try {
			
			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesFichiersImages set IDclient=?, DateCreation=?,"+
					" InfoPriseVue=?, Resolution=?, estPartage=?"+
					" where CheminAcces='"+obj.getChemin_acces()+"'"); 
			
			prepare.setInt(1,obj.getId_client());
			prepare.setDate(2, obj.getDate_creation());
			prepare.setString(3, obj.getInfo_prise_vue());
			prepare.setInt(4, obj.getResolution_img());
			prepare.setInt(5, obj.getEst_partage());
			
			
			
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(FichierImage obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supFichier = "delete from LesFichiersImages "+
								"where CheminAcces='"+obj.getChemin_acces()+"'";
			
			myStm.executeUpdate(supFichier);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

	
}
