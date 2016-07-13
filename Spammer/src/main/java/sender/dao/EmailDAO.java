package sender.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sender.domain.Email;

@Repository
public class EmailDAO {

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Email> findAll() {
		return em.createQuery("from email e").getResultList();

	}
	 @Transactional
		public void add(Email email) {
		 Email newEmail = em.merge(email);
			em.persist(newEmail);
			em.close();
		}
	
	 @Transactional
		public void delete(int id) {
		  Email email = em.find(Email.class, id);
		  em.remove(email);
		  em.close();
		}
}
