package metiers;
import java.sql.*;

public class TheConnection {

//	static final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";

// Ne pas oublier d'anomymiser le PASSWD avant de rendre votre travail

//	static final String USER = "A COMPLETER";
//	static final String PASSWD = "A COMPLETER";

	private static final String configurationFile = "src/BD.properties";
	static Connection connect;

	private TheConnection() {

		try {

			// Enregistrement du driver Oracle
			System.out.print("Loading Oracle driver... ");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("loaded");

			// Etablissement de la connection
			DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
			System.out.print("Connecting to the database... ");
			connect = DriverManager.getConnection(dap.getDatabaseUrl(), dap.getUsername(), dap.getPassword());
			System.out.println("connected");

			connect.setAutoCommit(true);

			// traitement d'exception
		} catch (SQLException e) {
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());

		}

	}

	public static Connection getInstance() {

		if (connect == null) {
			new TheConnection();
			System.out.println("Instanciation de la connexion SQL !\n");
		} else {
			System.out.println("Connexion SQL existante !");

		}
		return connect;
	}

}