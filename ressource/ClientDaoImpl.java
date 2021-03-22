package projet;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao{

		List<Client> clients;
		
		public ClientDaoImpl() {
			clients = new ArrayList<Client>();
			Client client1 = new Client(1, "pierre@uga.fr", "CHEVALIER", "Pierre", "pierre");
			Client client2 = new Client(2, "samuel@uga.fr", "LAURAS", "Samuel", "samuel");
			Client client3 = new Client(3, "joumana@uga.fr", "ELDAKAR", "Joumana", "joumana");
			Client client4 = new Client(4, "karim@uga.fr", "ABOUD", "Karim", "karim");
			Client client5 = new Client(5, "romeo@uga.fr", "AGOSSOU", "Romeo", "romeo");
			
			clients.add(client1);
			clients.add(client2);
			clients.add(client3);
			clients.add(client4);
			clients.add(client5);
		}
		

	   @Override
	   public void deleteClient(Client client) {
	      clients.remove(client.getIDclient());
	      System.out.println("Client: ID " + client.getIDclient() + ", deleted from database");
	   }

	   //retrive list of students from the database
	   @Override
	   public List<Client> getAllClients() {
	      return clients;
	   }

	   @Override
	   public Client getClient(int idclient) {
	      return clients.get(idclient);
	   }

	   @Override
	   public void updateClient(Client client) {
	      clients.get(client.getIDclient()).setNom(client.getNom());
	      System.out.println("Client: ID " + client.getIDclient() + ", updated in the database");
	   }
}
