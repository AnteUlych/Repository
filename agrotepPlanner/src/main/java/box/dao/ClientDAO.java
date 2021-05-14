package box.dao;


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
	public List<Client> getListOfClients(){
		return em.createQuery("from Client").getResultList();
	}

	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
	
	public Client getClientByCode(String code){
		Query query = em
				.createQuery("from Client where code = '" + code + "'");
		return (Client) query.getSingleResult();
	}
	
	public Client getClientById(int id){
		Client client = (Client) em.find(Client.class, id);
		return client;
	}
	
	public void editClientById(int id, int blacklist, String cargo, String company, String contactPerson, String email, String otherInfo, String payment, String phone, String season, String transportVolume, String typetruck, String warning){
		
		Client client = (Client) em.find(Client.class, id);

		client.setBlacklist(blacklist);
		client.setCargo(cargo);
		client.setCompany(company);
		client.setContactPerson(contactPerson);
		client.setEmail(email);
		client.setOtherInfo(otherInfo);
		client.setPayment(payment);
		client.setPhone(phone);
		client.setSeason(season);
		client.setTransportVolume(transportVolume);
		client.setTypetruck(typetruck);
		client.setWarning(warning);

		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
	


}
