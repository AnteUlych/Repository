package bird.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bird.model.Cargo;

@Repository
public class CargoDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Cargo> getAllActiveCargo() {
		return em.createQuery("from Cargo where active = '1' order by id desc").getResultList();
	}

	public Cargo getCargoBy(int id) {
		Query query = em.createQuery("from Cargo where id = '" + id + "'");
		return (Cargo) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> getAllCargoByClient(String client) {
		return em.createQuery("from Cargo where client = '" + client + "'")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cargo> getAllActiveCargosByClient(String client) {
		return em.createQuery(
				"from Cargo where client = '" + client + "' and active = '1' order by id desc")
				.getResultList();
	}

	@Transactional
	public void persist(Cargo cargo) {
		Cargo transaction = em.merge(cargo);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void editCargo(int id, String client, String description, int active) {

		Cargo cargo = (Cargo) em.find(Cargo.class, id);

		cargo.setActive(active);
		cargo.setClient(client);
		cargo.setDescription(description);

		Cargo transaction = em.merge(cargo);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editDeliveryDateForCargo(int id, Date delivery) { 

		Cargo cargo = (Cargo) em.find(Cargo.class, id);

		cargo.setDelivery(delivery);
		Cargo transaction = em.merge(cargo);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void deleteCargo(int id) {
		Cargo cargo = (Cargo) em.find(Cargo.class, id);
		Cargo transaction = em.merge(cargo);
		em.remove(transaction);
		em.close();
	}
	@Transactional
	public void finishCargo(int id) {
		
		Cargo cargo = (Cargo) em.find(Cargo.class, id);
		cargo.setActive(0);
		Cargo transaction = em.merge(cargo);
		em.persist(transaction);
		em.close();
		
	}
}
