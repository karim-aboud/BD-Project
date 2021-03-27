package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Impression;
import metiers.TiragePhoto;

public class TiragePhotoDAO extends DAO<TiragePhoto>{

	public TiragePhotoDAO(Connection conn) {
		super(conn);
		
	}

	@Override
	public boolean create(TiragePhoto obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LEsTiragesPhotos(IDimpress,refrce, CheminAcces, parametres, nbExemplaire"+
					" values(?,?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getIDimpress());
			prepare.setString(2, obj.getReference());
			prepare.setString(3, obj.getCheminAcces());
			prepare.setString(4, obj.getParametres());
			prepare.setInt(5, obj.getNbExemplaire());
			
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public TiragePhoto read(int id) {
		
		TiragePhoto tirage = new TiragePhoto();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesTiragesPhotos";
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				tirage = new TiragePhoto(id,rs.getString("refrce"), rs.getString("CheminAcces"),
										rs.getString("parametres"), rs.getInt("NbExemplaire"));
				
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tirage;
	}

	@Override
	public boolean update(TiragePhoto obj) {
		
		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesTiragesPhotos set CheminAcces=?, parametres=?, nbExemplaire=?"+
					" where IDimpress="+obj.getNbExemplaire());
			
			prepare.setString(1, obj.getCheminAcces());
			prepare.setString(2, obj.getParametres());
			prepare.setInt(2, obj.getNbExemplaire());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(TiragePhoto obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supTir = "delete from LesTiragesPhotos where IDimpress="+obj.getIDimpress();
			myStm.executeUpdate(supTir);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
		
	}

	

}
