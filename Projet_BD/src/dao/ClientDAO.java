package dao;

import java.sql.*;
import metiers.*;

public class ClientDAO extends DAO<Client> {

	public ClientDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Client obj) {

		int ins = 0;

		try {
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"insert into LesClients(IDclient,email,nom,prenom,mdp)"+
					" values(?,?,?,?,?)"
					);
			
			prepare.setInt(1,obj.getIdClient());
			prepare.setString(2, obj.getAdrMail());
			prepare.setString(3, obj.getNom());
			prepare.setString(4, obj.getPrenom());
			prepare.setString(5, obj.getMotDePasse());
			
			ins = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ins > 0;
	}

	@Override
	public Client read(int id) {
		
		Client client = new Client();
		
		FichierImageDAO fichierDAO = new FichierImageDAO(this.connect);
		CommandeDAO commandeDAO = new CommandeDAO(this.connect);
		AdresseDAO adresseDAO = new AdresseDAO(this.connect);
		
		try {
			Statement myStm = this.connect.createStatement(this.type,this.mode);
			String q = 	"SELECT * FROM LesClients " +
						"WHERE IDclient=" + id;

			ResultSet rs = myStm.executeQuery(q);
			
			
			if (rs.first()) {
				client = new Client(id,rs.getString("email"),rs.getString("nom"),
						rs.getString("prenom"),rs.getString("mdp"));
				
			}
			
			String q2 = "SELECT * FROM LesCommandes " +
					"WHERE IDclient=" + id;

			 rs = myStm.executeQuery(q);		
			 rs.next();

			while(rs.next()) {
				client.addCommande(commandeDAO.read(rs.getInt("IDcommande")));
			}
			
			String q3 = " SELECT CheminAcces FROM LesFichiersImages WHERE IDclient="+id;

			
			rs = myStm.executeQuery(q3);
			rs.beforeFirst();			
			
			while(rs.next()) {
				client.addFichierImage(fichierDAO.read(rs.getString("CheminAcces")));
			}
			
			String q4 = " SELECT * FROM LesAdresses WHERE IDclient="+id;

			
			rs = myStm.executeQuery(q4);
			rs.beforeFirst();			
			
			while(rs.next()) {
				client.addAdresse(adresseDAO.read(rs.getInt("IDadresse")));
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public boolean update(Client obj) {
		
		int upd = 0;
		
		try {			
			
			PreparedStatement prepare = this.connect.prepareStatement(
					"update LesClients set email=?, nom=?, prenom=?, mdp=?"+
					" where IDclient="+obj.getIdClient() );
			
			prepare.setString(1, obj.getAdrMail());
			prepare.setString(2, obj.getNom());
			prepare.setString(3, obj.getPrenom());
			prepare.setString(4, obj.getMotDePasse());
				    		
			upd = prepare.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return upd > 0;
	}

	@Override
	public boolean delete(Client obj) {

		int del = 0;
		
		try {
			Statement myStm = this.connect.createStatement();
			String supClient = "delete from LesClients where IDclient="+obj.getIdClient();
			myStm.executeUpdate(supClient);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return del > 0;
	}

}
