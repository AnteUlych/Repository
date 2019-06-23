package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Tender;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TenderDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void deleteTender(int tenderId) {
		Tender tender = (Tender) em.find(Tender.class, tenderId);
		Tender transaction = em.merge(tender);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void closeTender(int tenderId) {

		Tender tender = (Tender) em.find(Tender.class, tenderId);

		tender.setIsopen("closed");

		Tender transaction = em.merge(tender);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void persist(Tender tender) {
		Tender transaction = em.merge(tender);
		em.persist(transaction);
		em.close();
	}
	
	public Tender getTenderByTenderId(int tenderId) {
		Query query = em.createQuery("from Tender where id = '" + tenderId + "'");
		return (Tender) query.getSingleResult();
	}
	
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
