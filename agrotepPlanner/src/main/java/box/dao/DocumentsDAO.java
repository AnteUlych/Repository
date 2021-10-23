package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Documents;



@Repository
public class DocumentsDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Documents> getListOfDocumentsWithStatus(String status){
	    return em.createQuery("from Documents where status='"+status+"' order by id desc").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Documents> getListOfDocumentsWithStatusByResponsibleId(String status, int responsibleid){
	    return em.createQuery("from Documents where status='"+status+"' and responsibleid='"+responsibleid+"' order by id desc").getResultList();
	}
	
	public void editDocumentsById(int id, Date datesolvving, String status, String color){
		
		Documents documents = (Documents) em.find(Documents.class, id);

		documents.setDatesolvving(datesolvving);
		documents.setStatus(status);
		documents.setColor(color);

		Documents transaction = em.merge(documents);
		em.persist(transaction);
		em.close();
	}
	
	public void editDocumentsLogistcomentById(int id, String logistcoment){
		
		Documents documents = (Documents) em.find(Documents.class, id);

		documents.setLogistcoment(logistcoment);
		
		Documents transaction = em.merge(documents);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void persist(Documents documents) {
		Documents transaction = em.merge(documents);
		em.persist(transaction);
		em.close();
	}

}
