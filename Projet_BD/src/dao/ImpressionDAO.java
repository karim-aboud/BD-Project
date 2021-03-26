package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Commande;
import metiers.Impression;

public class ImpressionDAO extends DAO<Impression> {

	public ImpressionDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Impression obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesImpressions(IDimpress,IDclient)"+
					"values(?,?)"
					);
			
			prepare.setInt(1,obj.getId_impression());
			prepare.setInt(2, obj.getId_client());
			
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Impression read(int id) {
		
		Impression impression = new Impression();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesImpressions";
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				impression = new Impression(id,rs.getInt("IDclient"));
				
			}
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return impression;
		
	}

	@Override
	public boolean update(Impression obj) {
		
		
		return false;
		
	}

	@Override
	public boolean delete(Impression obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supImp = "delete from LesImpressions where IDimpress="+obj.getId_impression();
			myStm.executeUpdate(supImp);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
