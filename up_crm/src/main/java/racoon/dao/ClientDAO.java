package racoon.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Client;

@Repository
public class ClientDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAllClientsByManager(String manager) {
		return em.createQuery(
				"from Client where manager = '" + manager
						+ "' order by nextcall").getResultList();
	}

	public Client getClientByCode(String code) {
		Query query = em.createQuery("from Client where code = '" + code + "'");
		return (Client) query.getSingleResult();
	}

	public Client getClientById(int id) {
		Query query = em.createQuery("from Client where id = '" + id + "'");
		return (Client) query.getSingleResult();
	}

	@Transactional
	public void editClient(int id, String company, String phone, String person,
			String category, String mail) {

		Client client = (Client) em.find(Client.class, id);

		client.setCompany(company);
		client.setPhone(phone);
		client.setPerson(person);
		client.setCategory(category);
		client.setMail(mail);

		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();

	}

	@Transactional
	public void editClientStatus(int id, String answer, Date nextcall,
			String funnel) {

		Client client = (Client) em.find(Client.class, id);

		client.setAnswer(answer);
		client.setNextcall(nextcall);
		client.setFunnel(funnel);

		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
}
