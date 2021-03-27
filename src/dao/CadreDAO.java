package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Cadre;
import metiers.Calendrier;

public class CadreDAO extends DAO<Cadre> {

	public CadreDAO(Connection conn) {
		super(conn);

	}

	@Override
	public boolean create(Cadre obj) {

		int ins = 0;

		try {

			PreparedStatement prepare = this.connect
					.prepareStatement("insert into LesCadres(IDimpress,refrce) values(?,?)");

			prepare.setInt(1, obj.getId_impression());
			prepare.setString(2, obj.getReference());

			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Cadre read(int id) {

		Cadre cadre = new Cadre();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesCadres WHERE IDimpress="+id;
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				cadre = new Cadre(id,rs.getString("refrce"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cadre;
	}

	@Override
	public boolean update(Cadre obj) {

		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesCadres set refrce=? "+
					"where IDimpression="+obj.getId_impression() );
			
			prepare.setString(1, obj.getReference());
			
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Cadre obj) {

		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supCadre = "delete from LesCadres where refrce='"+obj.getReference()+"'";
			myStm.executeUpdate(supCadre);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
