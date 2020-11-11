package box.service;

import java.util.ArrayList;
import java.util.Date;
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
	
	public void editNectcallAndLastrecordAndFunekOfClientById(int id, Date nextcall, int funel, String lastrecord){
		dao.editNectcallAndLastrecordAndFunekOfClientById(id, nextcall, funel, lastrecord);
	}
	
	public void editClientById(int id, int funel, String company, String edrpo, String freight,
			String lpr, String mail, String manager, int managerid,
			String mobile, String othercontact, String phone, String  products){
		dao.editClientById(id, funel, company, edrpo, freight, lpr, mail, manager, managerid, mobile, othercontact, phone, products);
	}
	
	public int getNumberOfClientsByManagerid(int managerid) {
		return dao.getNumberOfClientsByManagerid(managerid);
	}
	
	public List<Client> getClientsByFunelAndOpenProduct(int funel, String product){
		List<Client> clientsByFunel = dao.getClientsByFunel(funel);
		List<Client> clientsByFunelAndProduct = new ArrayList();
		for(Client client:clientsByFunel){
			if(client.getProducts().contains(product)){
				clientsByFunelAndProduct.add(client);
			}
		}
		
		return clientsByFunelAndProduct;
	}
	
	public List<Client> getClientsByManagerIdBetweenDates(int managerid, String start, String finish){
		return dao.getClientsByManagerIdBetweenDates(managerid, start, finish);
	}

}
