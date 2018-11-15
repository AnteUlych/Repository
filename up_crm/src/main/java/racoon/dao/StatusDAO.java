package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Status;

@Repository
public class StatusDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(Status status) {
		Status transaction = em.merge(status);
		em.persist(transaction);
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Status> getAllStatusByCompanyId(int clientId) {
		return em
				.createQuery("from Status where clientId = '" + clientId + "' order by id desc")
				.getResultList();
	}

}
