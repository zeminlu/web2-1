package model;

import java.util.LinkedList;
import java.util.List;

public class ClientManager {
	private List<Client> clients = new LinkedList<Client>();
	private static ClientManager instance = null;
	
	public static ClientManager getInstance(){
		if (instance == null){
			return instance = new ClientManager();
		}
		return instance;
	}
	
	public void addClient(Client client){
		clients.add(client);
	}
	
	public boolean deleteClient(Client client){
		if (!clients.contains(client)){
			return false;
		}
		clients.remove(client);
		return true;
	}
	
	public Client getClient(int id){
		for(Client each: clients){
			if (each.getId() == id){
				return each;
			}
		}
		return null;
	}
}
