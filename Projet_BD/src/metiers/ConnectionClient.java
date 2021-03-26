package metiers;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionClient  {
	
	Connection conn;
	int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
	int mode = ResultSet.CONCUR_UPDATABLE;
	
	public ConnectionClient(Connection conn) {
		this.conn = conn;
	}

	public void creerUnCompte() throws SQLException{
		System.out.println("\n--------------Creation Client--------------");
		System.out.print("Nom:");
		String nom = LectureClavier.lireChaine();
		System.out.print("Prenom:");
		String prenom = LectureClavier.lireChaine();
		System.out.print("Mail:");
		String mail = LectureClavier.lireChaine();
		System.out.print("Mot de passe:");
		String mdp = LectureClavier.lireChaine();
		
		String newId = "SELECT MAX(id_client)+1 AS id_client FROM LesClients";
		Statement Stm = conn.createStatement();
		ResultSet rs = Stm.executeQuery(newId); 
		rs.next();
		int id = rs.getInt("id_client");
		
		String ajout = "INSERT INTO LesClients(IDclient,email,nom,"+
						"prenom,mdp) "+
						String.format(" values(%d,'%s','%s','%s','%s')",
								id, mail, nom , prenom,mdp);
		
		Stm.executeUpdate(ajout);
		
		
	}
	
	public int connectionCompte() throws SQLException{
		
		ResultSet rs;
		System.out.println("\n--------------Connection Client--------------");
		do {
			
			System.out.print("mail:");
			String mail = LectureClavier.lireChaine();
			System.out.print("mot de passe:");
			String mdp = LectureClavier.lireChaine();
			
			String exist = "SELECT IDclient FROM LesClients WHERE "+
							"email='"+mail+"' AND mdp='"+mdp+"'";
			
			Statement Stm = conn.createStatement(this.type,this.mode);
			
			rs = Stm.executeQuery(exist); 
			
			if(!rs.first()) System.out.println("Identifiants inccorectes.");
			
		} while(!rs.first());
		
		return rs.getInt("IDclient");

	}

}
