package box.dao;

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
