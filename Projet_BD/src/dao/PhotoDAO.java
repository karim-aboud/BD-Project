package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Commande;
import metiers.Photo;

public class PhotoDAO extends DAO<Photo>{
	
	public PhotoDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Photo obj) {

		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesPhotos(IDphoto,IDpage,CheminAcces,parametres,"+
					"textDescrip) values(?,?,?,?,?)" );
			
			prepare.setInt(1, obj.getId_photo());
			prepare.setInt(2,obj.getId_page());
			prepare.setString(3, obj.getChemin_acces());
			prepare.setString(4, obj.getParametres());
			prepare.setString(5, obj.getText_descriptif());			
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Photo read(int id) {
		Photo photo = new Photo();
		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesPhotos WHERE IDphoto=" + id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				photo = new Photo(id,rs.getInt("IDpage"),rs.getString("CheminAcces"),
									rs.getString("parametres"),rs.getString("textDescrip"));
			}
							
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return photo;
		
	}

	@Override
	public boolean update(Photo obj) { // FAUX
		
		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesPhotos set parametres=?, textDescrip=?"+
					"where IDphoto="+obj.getId_photo());
			
			prepare.setString(1, obj.getParametres());
			prepare.setString(2, obj.getText_descriptif());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Photo obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supPhoto = "delete from LesPhotos where IDphoto="+obj.getId_photo();
			myStm.executeUpdate(supPhoto);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}


}
