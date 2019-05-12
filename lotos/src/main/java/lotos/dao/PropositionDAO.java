package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Proposition;

import org.springframework.stereotype.Repository;

@Repository
public class PropositionDAO {

	@PersistenceContext
	private EntityManager em;
	
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
