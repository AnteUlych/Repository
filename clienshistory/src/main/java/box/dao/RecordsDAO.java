package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Client;
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
	
	@SuppressWarnings("unchecked")
	public List<Records> getListOfRecordsByManagerIdIdAndStatusBetweenDates(int managerid, int recordstatus, String start, String finish) {
		return em.createQuery(
				"from Records where managerid = '" + managerid + "' and recordstatus ='"+recordstatus+"' and date >='"+start+"' and date <='"+finish+"'")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Records> getListOfRecordsByManagerIdsBetweenDates(int managerid, String start, String finish) {
		return em.createQuery(
				"from Records where managerid = '" + managerid + "' and date >='"+start+"' and date <='"+finish+"' order by date desc")
				.getResultList();
	}
	


}
