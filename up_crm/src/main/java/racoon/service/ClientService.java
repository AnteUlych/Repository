package racoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import racoon.dao.ClientDAO;
import racoon.model.Client;


@Service("ClientService")
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDAO dao;

	public void addClient(Client client) {
		dao.persist(client);
	}
	
	public List<Client> getAllClientsByManager(String manager){
		return dao.getAllClientsByManager(manager);
	}
	
	public Client getClientById(int id){
		return dao.getClientById(id);
	}

}
