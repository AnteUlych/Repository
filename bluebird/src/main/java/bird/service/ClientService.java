package bird.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bird.dao.ClientDAO;
import bird.model.Client;


@Service("ClientService")
public class ClientService {

	@Autowired
	private ClientDAO dao;
	
	public List<Client> getAllClients() {
		  return dao.getAllClients();
	}
	public Client getClientBy(int id){
		return dao.getClientBy(id);
	}
	 public Client getClientBy(String login, String password) {
		return dao.getClientBy(login, password);
		 
	 }
	 public void addClient(String company, String name, String email, String phone, String login, String password){
		 
		 Client client = new Client();
		 
		 client.setCompany(company);
		 client.setEmail(email);
		 client.setLogin(login);
		 client.setName(name);
		 client.setPassword(password);
		 client.setPhone(phone);
		 
		 dao.persist(client);
	 }
	 
		 public void editClient(int id, String company, String name, String email, String phone, String login, String password){
			 dao.editClient(id, company, name, email, phone, login, password);
		 }
	 }

