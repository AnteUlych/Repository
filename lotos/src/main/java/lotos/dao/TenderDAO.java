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
	public List<Tender> getOpenTenders() {
		return em.createQuery(
				"from Tender where isopen = 'open' order by id desc")
				.getResultList();
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<Tender> getOpenTendersFiltrFrom(int more, int less, String countryfrom) {
		return em.createQuery(
				"from Tender where countryfrom = '" + countryfrom + "' and weight >=  '" + more + "' and weight <=  '" + less + "' and isopen = 'open' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tender> getOpenTendersFiltrTo(int more, int less, String countryto) {
		return em.createQuery(
				"from Tender where countryto = '" + countryto + "' and weight >=  '" + more + "' and weight <=  '" + less + "' and isopen = 'open' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tender> getOpenTendersFiltrFromTo(int more, int less, String countryfrom, String countryto) {
		return em.createQuery(
				"from Tender where countryfrom = '" + countryfrom + "' and countryto = '" + countryto + "' and weight >=  '" + more + "' and weight <=  '" + less + "' and isopen = 'open' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tender> getOpenTendersFiltrWeight(int more, int less) {
		return em.createQuery(
				"from Tender where weight >=  '" + more + "' and weight <=  '" + less + "' and isopen = 'open' order by id desc")
				.getResultList();
	}
	
}
