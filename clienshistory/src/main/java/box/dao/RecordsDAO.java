package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Records;


@Repository
public class RecordsDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Records record) {
		Records transaction = em.merge(record);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Records> getListOfRecordsByClientId(int clientid) {
		return em.createQuery(
				"from Records where clientid = '" + clientid + "' order by date desc")
				.getResultList();
	}

}
