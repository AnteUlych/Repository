package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Client;

@Repository
public class ClientDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return em.createQuery(
				"from Client where managerid = '" + managerid + "' order by nextcall")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsSortedByNextcall() {
		return em.createQuery(
				"from Client order by nextcall")
				.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getListOfClients(){
		return em.createQuery("from Client").getResultList();
	}
	
	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
	
	public Client getClientByERDPO(String edrpo) {
		Query query = em
				.createQuery("from Client where edrpo = '" + edrpo + "'");
		return (Client) query.getSingleResult();
	}
	
	public int getNumberOfClientsByManagerid(int managerid) {
		return em
				.createQuery("from Client where managerid = '" + managerid + "'").getResultList().size();
		
	}
	
	public Client getClientById(int id){
		Client client = (Client) em.find(Client.class, id);
		return client;
	}
	
	@Transactional
	public void editNectcallAndLastrecordAndFunekOfClientById(int id, Date nextcall, int funel, String lastrecord){
		
		Client client = (Client) em.find(Client.class, id);
		client.setLastrecord(lastrecord);
		client.setNextcall(nextcall);
		client.setFunel(funel);
		
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();

	}
	
	public void editClientById(int id, int funel, String company, String edrpo, String freight,
			String lpr, String mail, String manager, int managerid,
			String mobile, String othercontact, String phone, String  products){
		
		Client client = (Client) em.find(Client.class, id);
		
		client.setCompany(company);
		client.setEdrpo(edrpo);
		client.setFreight(freight);
		client.setFunel(funel);
		client.setLpr(lpr);
		client.setMail(mail);
		client.setManager(manager);
		client.setManagerid(managerid);
		client.setMobile(mobile);
		client.setOthercontact(othercontact);
		client.setPhone(phone);
		client.setProducts(products);
		
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
	
}
