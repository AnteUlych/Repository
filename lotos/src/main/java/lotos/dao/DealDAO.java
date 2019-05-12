package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Deal;

import org.springframework.stereotype.Repository;

@Repository
public class DealDAO {

	@PersistenceContext
	private EntityManager em;

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
