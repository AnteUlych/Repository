package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Proposition;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PropositionDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void deleteProposition(int propositionId) {
		Proposition proposition = (Proposition) em.find(Proposition.class, propositionId);
		Proposition transaction = em.merge(proposition);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void persist(Proposition proposition) {
		Proposition transaction = em.merge(proposition);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropositionsByTenderId(int tenderId) {
		return em.createQuery(
				"from Proposition where tenderid = '" + tenderId + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Proposition> getPropositionsByCompanyId(int companyId) {
		return em.createQuery(
				"from Proposition where companyid = '" + companyId + "'")
				.getResultList();
	}
}
