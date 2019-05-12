package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Recomendation;

import org.springframework.stereotype.Repository;

@Repository
public class RecomendationDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public List<Recomendation> getRecomendationsByCompanyId(int companyid, String rate) {
		return em
				.createQuery("from Recomendation where companyid = '" + companyid + "'  and rate = '" + rate + "' order by id desc")
				.getResultList();
	}
	
}
