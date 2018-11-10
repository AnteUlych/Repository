package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Proposition;


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
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getAllPropositionsByRequest(int idRequest) {
		return em.createQuery("from Proposition where requestId = '" + idRequest + "'")
				.getResultList();
	}
	
	@Transactional
	public void deleteProposition(int id) {
		Proposition proposition = (Proposition) em.find(Proposition.class, id);
		Proposition transaction = em.merge(proposition);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void desideProposition(int id, String result) {

		Proposition proposition = (Proposition) em.find(Proposition.class, id);

		proposition.setResult(result);

		Proposition transaction = em.merge(proposition);
		em.persist(transaction);
		em.close();
	}
	
	

}
