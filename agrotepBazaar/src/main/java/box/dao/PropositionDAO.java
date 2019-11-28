package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Proposition;

@Repository
public class PropositionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Proposition proposition) {
		Proposition transaction = em.merge(proposition);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteProposition(int id) {
		Proposition proposition = (Proposition) em.find(Proposition.class, id);
		Proposition transaction = em.merge(proposition);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void editStatusOfProposition(int id, String status) {
		
		Proposition proposition = (Proposition) em.find(Proposition.class, id);

		proposition.setStatus(status);

		Proposition transaction = em.merge(proposition);
		em.persist(transaction);
		em.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getListOfPropositionsByDirection(String direction) {
		return em.createQuery(
				"from Proposition where direction = '" + direction + "' order by id desc")
				.getResultList();
	}
	

}
