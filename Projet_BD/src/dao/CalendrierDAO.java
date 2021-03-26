package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Calendrier;
import metiers.Impression;

public class CalendrierDAO extends DAO<Calendrier>{

	public CalendrierDAO(Connection conn) {
		super(conn);
		
	}

	@Override
	public boolean create(Calendrier obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesCalendriers(IDimpress,refrce)"+
					" values(?,?)"
					);
			
			prepare.setInt(1,obj.getId_impression());
			prepare.setString(2, obj.getReference());
			
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Calendrier read(int id) {
		
		Calendrier calendrier = new Calendrier();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesCalendriers";
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				calendrier = new Calendrier(id,rs.getString("refrce"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return calendrier;
	}

	@Override
	public boolean update(Calendrier obj) {
		
		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesCalendriers set refrce=? "+
					"where IDclient="+obj.getId_impression() );
			
			prepare.setString(1, obj.getReference());
			
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Calendrier obj) {
		
		return false;
	}
	
	

}
