package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PropositionDAO {
	
	@PersistenceContext
	private EntityManager em;

}
