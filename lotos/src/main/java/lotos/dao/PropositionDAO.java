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
	
	//test
	@SuppressWarnings("unchecked")
	public List<Proposition> getAllPropositions() {
		return em
				.createQuery("from Proposition")
				.getResultList();
	}
	//test
}
