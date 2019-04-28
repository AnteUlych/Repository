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
	
	//test
	@SuppressWarnings("unchecked")
	public List<Recomendation> getAllRecomendations() {
		return em
				.createQuery("from Recomendation")
				.getResultList();
	}
	//test
}
