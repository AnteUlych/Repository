package beagle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import beagle.model.Access;

@Repository
public class AccessDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Access> getAccessList() {
		return em.createQuery("from Access").getResultList();
	}

}
