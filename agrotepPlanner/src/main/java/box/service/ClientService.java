package box.service;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ClientDAO;
import box.model.Client;
import box.model.Direction;

@Service("ClientService")
@Transactional
public class ClientService {

	@Autowired
	private ClientDAO dao;
	
	public List<Client> getListOfClients(){
		return dao.getListOfClients();
	}
	
	public void addClient(Client client) {
		dao.persist(client);
	}
	
	public int getClientIdByCode(String code){
		return dao.getClientByCode(code).getId();
	}
	
	public boolean isClientExistbyCode(String code){
		try{
		Client c = dao.getClientByCode(code);
		return true;
		}catch(NoResultException e){
			return false;
		}
	}
	
	public Client getClientById(int id){
		return dao.getClientById(id);
	}
	
	public void editClientById(int id, int blacklist, String cargo, String company, String contactPerson, String email, String otherInfo, String payment, String phone, String season, String transportVolume, String typetruck, String warning){
		dao.editClientById(id, blacklist, cargo, company, contactPerson, email, otherInfo, payment, phone, season, transportVolume, typetruck, warning);
	}
	
	
}
