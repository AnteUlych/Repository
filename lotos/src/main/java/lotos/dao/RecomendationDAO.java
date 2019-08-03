package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Recomendation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RecomendationDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void deleteRecomendation(int id) {
		Recomendation comment = (Recomendation) em.find(Recomendation.class, id);
		Recomendation transaction = em.merge(comment);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void hideRecomendation(int id) {

		Recomendation comment = (Recomendation) em.find(Recomendation.class, id);

		comment.setRate("hidden");

		Recomendation transaction = em.merge(comment);
		em.persist(transaction);
		em.close();
	}
	
	public Recomendation getRecomendationById(int id) {
		Query query = em.createQuery("from Recomendation where id = '" + id + "'");
		return (Recomendation) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Recomendation> getRecomendationsByCompanyId(int companyid, String rate) {
		return em
				.createQuery("from Recomendation where companyid = '" + companyid + "'  and rate = '" + rate + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Recomendation> getListRecomendationsByCompanyId(int companyid) {
		return em
				.createQuery("from Recomendation where companyid = '" + companyid + "' order by id desc")
				.getResultList();
	}
	
	public Recomendation getRecomendationByDealId(int dealid) {
		Query query = em.createQuery("from Recomendation where dealid = '" + dealid + "'");
		return (Recomendation) query.getSingleResult();
	}
	
	@Transactional
	public void persist(Recomendation recomendation) {
		Recomendation transaction = em.merge(recomendation);
		em.persist(transaction);
		em.close();
	}
	
}
