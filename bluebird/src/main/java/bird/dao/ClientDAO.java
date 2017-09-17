package bird.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bird.model.Client;

@Repository
public class ClientDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
		return em.createQuery("from Client").getResultList();
	}

	public Client getClientBy(int id) {
		Query query = em.createQuery("from Client where id = '" + id + "'");
		return (Client) query.getSingleResult();
	}

	public Client getClientBy(String login, String password) {
		Query query = em.createQuery("from Client where login = '" + login
				+ "' AND password= '" + password + "'");
		return (Client) query.getSingleResult();
	}

	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void editClient(int id, String company, String name, String email,
			String phone, String login, String password) {

		Client client = (Client) em.find(Client.class, id);

		client.setCompany(company);
		client.setEmail(email);
		client.setLogin(login);
		client.setName(name);
		client.setPassword(password);
		client.setPhone(phone);

		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
}
