package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Album;

public class AlbumDAO extends DAO<Album> {

	public AlbumDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Album obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesAlbums(IDimpress,refrce,titre,couverture)"+
					"values(?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getId_impression());
			prepare.setString(2, obj.getReference());
			prepare.setString(3, obj.getTitre());
			prepare.setInt(4, obj.getCouverture());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Album read(int id) {
		
		Album album = new Album();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesAlbums " +
						" WHERE IDimpress=" + id;
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				album = new Album(id,rs.getString("refrce"),
						rs.getString("titre"), rs.getInt("couverture"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return album;
	}

	@Override
	public boolean update(Album obj) {
		
		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesAlbums set titre=?, set couverture=?, "+
					"where IDimpress="+obj.getId_impression() );

			prepare.setString(1,obj.getTitre());
			prepare.setInt(2, obj.getCouverture());
			
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Album obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAlbum = "delete from LesAlbums where IDimpress="+obj.getId_impression();
			myStm.executeUpdate(supAlbum);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
