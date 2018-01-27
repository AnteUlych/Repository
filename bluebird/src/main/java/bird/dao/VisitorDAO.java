package bird.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bird.model.Visitor;

@Repository
public class VisitorDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Visitor> getAllVisitors() {
		return em.createQuery("from Visitor order by id desc").getResultList();
	}

	@Transactional
	public void persist(Visitor visitor) {
		Visitor transaction = em.merge(visitor);
		em.persist(transaction);
		em.close();
	}
}
