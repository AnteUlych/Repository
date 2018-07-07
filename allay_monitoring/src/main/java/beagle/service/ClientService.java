package beagle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beagle.dao.ClientDAO;
import beagle.model.Client;

@Service("ClientService")
public class ClientService {

	@Autowired
	private ClientDAO dao;
	
	public List<Client> getAllClientsInfo() {
		return dao.getAllClients();
	}
	
	public void editManager(int id, String manager) {
		dao.editManager(id, manager);
	}

	public List<String> getAllClients() {

		List<Client> clients = dao.getAllClients();
		List<String> companies = new ArrayList();

		for (Client client : clients) {
			companies.add(client.getCompany());
		}

		return companies;
	}

	public Client getClientByCompany(String company) {
		return dao.getClientByCompany(company);
	}

	public void addClient(Client client) {
		dao.persist(client);
	}

}
