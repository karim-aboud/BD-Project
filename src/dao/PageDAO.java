package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Album;
import metiers.Page;

public class PageDAO extends DAO<Page>{
	
	public PageDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Page obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesPages(IDpage,IDimpress,noPage,MiseEnForme) "+
					"values(?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getIDpage());
			prepare.setInt(2, obj.getIDimpress());
			prepare.setInt(3, obj.getNoPage());
			prepare.setString(4, obj.getMiseEnForme());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Page read(int id) {
		
		Page page = new Page();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesPages " +
						" WHERE IDpage=" + id;
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				page = new Page(id,rs.getInt("IDimpress"),rs.getInt("noPage"),
						rs.getString("MiseEnForme"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public boolean update(Page obj) {
		
		int upd = 0;
		
		try {
						
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesPages set MiseEnForme=? "+
					"where IDpage="+obj.getIDpage());
			
			prepare.setString(1, obj.getMiseEnForme());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Page obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supPhoto = "delete from LesPages where IDpage="+obj.getIDpage();
			myStm.executeUpdate(supPhoto);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}
	
}
