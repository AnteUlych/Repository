package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
