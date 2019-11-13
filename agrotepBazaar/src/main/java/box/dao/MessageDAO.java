package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Message;

@Repository
public class MessageDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Message message) {
		Message transaction = em.merge(message);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteMessage(int id) {
		Message message = (Message) em.find(Message.class, id);
		Message transaction = em.merge(message);
		em.remove(transaction);
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Message> getMessageByRecipientid(int recipientid){
		return  em.createQuery("from Message where recipientid = '" + recipientid + "'").setMaxResults(1).getResultList();

	}

}
