package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import box.model.Maplink;

@Repository
public class MaplinkDAO {

	@PersistenceContext
	private EntityManager em;

	public Maplink getMaplinkById(int id) {
		Maplink maplink = (Maplink) em.find(Maplink.class, id);
		return maplink;
	}

	public void editMaplinkById(int id, String link) {

		Maplink maplink = (Maplink) em.find(Maplink.class, id);

		maplink.setLink(link);

		Maplink transaction = em.merge(maplink);
		em.persist(transaction);
		em.close();
	}

}
