package projet;

import java.util.List;

public interface ClientDao {
	public List<Client> getAllClients();
   public Client getClient(int idclient);
   public void updateClient(Client client);
   public void deleteClient(Client client);
}
