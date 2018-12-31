package racoon.service;

import java.util.Date;
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

	public List<Client> getAllClientsByManager(String manager) {
		return dao.getAllClientsByManager(manager);
	}

	public List<Client> getAllClientsByFunnel(String funnel) {
		return dao.getAllClientsByFunnel(funnel);
	}
	
	public Client getClientById(int id) {
		return dao.getClientById(id);
	}

	public void editClientStatus(int id, String answer, Date nextcall,
			String funnel) {
		dao.editClientStatus(id, answer, nextcall, funnel);
	}

	public void editClient(int id, String company, String phone, String person,
			String category, String mail) {
		dao.editClient(id, company, phone, person, category, mail);
	}

	public Client getClientByCode(String code) {
		return dao.getClientByCode(code);
	}

}
