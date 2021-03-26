package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metiers.Adresse;

public class AdresseDAO extends DAO<Adresse> {

	public AdresseDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Adresse obj) {
		
		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesAdresses(IDadresse,noRue,nomRue,ville,CodePostal,IDclient)"+
					"values(?,?,?,?,?,?)"
					);
			
			prepare.setInt(1, obj.getId_adresse());
			prepare.setInt(2, obj.getNumRue());
			prepare.setString(3, obj.getNomRue());
			prepare.setString(4, obj.getVille());
			prepare.setInt(5, obj.getCodePostal());
			prepare.setInt(6,obj.getIdClient());

			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}
		
	public Adresse read(int id) {
		
		Adresse adresse = new Adresse();		
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesAdresses " +
						"WHERE IDadresse="+id;
			
			ResultSet rs = myStm.executeQuery(q);
			
			if (rs.first()) {
				adresse = new Adresse(id,rs.getInt("noRue"),rs.getString("nomRue"),
						rs.getString("ville"),rs.getInt("CodePostal"),rs.getInt("IDclient"));		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adresse;
	}

	@Override
	public boolean update(Adresse obj) {
		
		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesAdresses set noRue=?, nomRue=?, ville=?, CodePostal=?"+
					"where IDadresse="+obj.getIdClient() );
			
			prepare.setInt(1, obj.getNumRue());
			prepare.setString(2, obj.getNomRue());
			prepare.setString(3, obj.getVille());
			prepare.setInt(4, obj.getCodePostal());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Adresse obj) {
		
		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supAdresse = "delete from LesAdresses where IDadresse="+obj.getId_adresse();
			myStm.executeUpdate(supAdresse);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
