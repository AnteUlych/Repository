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
	
	//test
	@SuppressWarnings("unchecked")
	public List<Tender> getAllTenders() {
		return em
				.createQuery("from Tender")
				.getResultList();
	}
	//test
}
