package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import box.model.Direction;


@Repository
public class DirectionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Direction> getListOfDirectionsByOblastAndClientid(int clientId, String oblast) {
		return em.createQuery("from Direction where oblastFrom='"+oblast+"' and clientId='"+clientId+"'").getResultList();
	}

}
