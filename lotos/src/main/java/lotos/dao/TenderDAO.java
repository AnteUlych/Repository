package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Tender;

import org.springframework.stereotype.Repository;


@Repository
public class TenderDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Tender> getOpenTendersByCompanyId(int companyId) {
		return em.createQuery(
				"from Tender where companyid = '" + companyId + "' and isopen = 'open' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tender> getTendersByCompanyId(int companyId) {
		return em.createQuery(
				"from Tender where companyid = '" + companyId + "' order by id desc")
				.getResultList();
	}
}
