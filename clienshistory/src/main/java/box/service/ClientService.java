package box.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import box.dao.ClientDAO;
import box.model.Client;

@Service("ClientService")
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDAO dao;

	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return dao.getClientsByManagerIdSortedByNexcall(managerid);
	}

	public List<Client> getClientsSortedByNextcall() {
		return dao.getClientsSortedByNextcall();
	}

	public List<Client> getListOfClients(){
		return dao.getListOfClients();
	}
	
	public Client getClientByERDPO(String edrpo) {
		return dao.getClientByERDPO(edrpo);
	}
	
	public void addClient(Client client) {
		dao.persist(client);
	}
	
	public Client getClientById(int id){
		return dao.getClientById(id);
	}

}
