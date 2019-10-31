package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Archiveauction;


@Repository
public class ArchiveauctionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Archiveauction archiveauction) {
		Archiveauction transaction = em.merge(archiveauction);
		em.persist(transaction);
		em.close();
	}

}
