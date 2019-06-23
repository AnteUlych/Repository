package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Deal;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DealDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Deal deal) {
		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Deal> getDealsByCompanyOrPropositionId(int companytenderid, int companypropositionid) {
		return em
				.createQuery("from Deal where companytenderid = '" + companytenderid + "' or companypropositionid = '" + companypropositionid + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getClosingDealsByCompanyId(int companytenderid) {
		return em
				.createQuery("from Deal where companytenderid = '" + companytenderid + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Deal> getWinningDealsByCompanyId(int companypropositionid) {
		return em
				.createQuery("from Deal where companypropositionid = '" + companypropositionid + "' order by id desc")
				.getResultList();
	}

}
