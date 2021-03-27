package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metiers.Cadre;
import metiers.Stock;

public class StockDAO extends DAO<Stock>{

	public StockDAO(Connection conn) {
		super(conn);
		
	}

	@Override
	public boolean create(Stock obj) {
		
		int ins = 0;

		try {

			PreparedStatement prepare = this.connect
					.prepareStatement("insert into LesStocks(refrce,quantite) values(?,?)");

			prepare.setString(1, obj.getReference());
			prepare.setInt(2, obj.getQuantite());

			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}
	
	@Override
	public Stock read(int id) {return null;}
	
	
	public Stock read(String ref) {
		
		Stock stock = new Stock();
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesStocks";
			
			ResultSet rs = myStm.executeQuery(q);

			if (rs.first()) {
				stock = new Stock(ref,rs.getInt("quantite"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stock;
	}

	@Override
	public boolean update(Stock obj) {
		
		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesStocks set quantite=? "+
					"where refrce='"+obj.getReference()+"'" );
			
			prepare.setInt(1, obj.getQuantite());
			
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Stock obj) {
		// par trigger
		return false;
	}
	
	
	
	
}
