package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Archivebet;

@Repository
public class ArchivebetDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Archivebet archivebet) {
		Archivebet transaction = em.merge(archivebet);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Archivebet> getListOfArchivebetByManagerIdDates(String start, String ending, int managerid) {
		return em.createQuery(
				"from Archivebet where date >= '" + start+"' and date <= '"+ ending+"'  and managerid = '"+ managerid+"'")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Archivebet> getListOfArchivebetByManagerIdAndStatusDates(String start, String ending, int managerid, String status) {
		return em.createQuery(
				"from Archivebet where date >= '" + start+"' and date <= '"+ ending+"'  and managerid = '"+ managerid+"' and status = '"+ status+"'")
				.getResultList();
	}
	
	public Archivebet getArchivebetByBetid(int betid) {
		Query query = em
				.createQuery("from Archivebet where betid = '" + betid + "'");
		return (Archivebet) query.getSingleResult();	
	}
	
	@Transactional
	public void editArchivebetById(int id, String status) {

		Archivebet archivebet = (Archivebet) em.find(Archivebet.class, id);

		archivebet.setStatus(status);

		Archivebet transaction = em.merge(archivebet);
		em.persist(transaction);
		em.close();
	}

}
