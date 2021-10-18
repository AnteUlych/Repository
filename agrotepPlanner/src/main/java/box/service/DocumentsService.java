package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.DocumentsDAO;
import box.model.Documents;


@Service("DocumentsService")
@Transactional
public class DocumentsService {
	
	@Autowired
	private DocumentsDAO dao;
	
	public List<Documents> getListOfDocumentsWithStatus(String status){
		return dao.getListOfDocumentsWithStatus(status);
	}
	
	public List<Documents> getListOfDocumentsWithStatusByResponsibleId(String status, int responsibleid){
		return dao.getListOfDocumentsWithStatusByResponsibleId(status, responsibleid);
	}
	
	public void editDocumentsById(int id, Date datesolvving, String status, String color){
		dao.editDocumentsById(id, datesolvving, status, color);
	}
	
	public void addDocuments(Documents documents) {
		dao.persist(documents);
	}

}
