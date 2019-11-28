package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.PropositionDAO;
import box.model.Proposition;

@Service("PropositionService")
@Transactional
public class PropositionService {
	
	@Autowired
	private PropositionDAO dao;
	
	public void addProposition(Proposition proposition) {
		dao.persist(proposition);
	}
	
	public void deleteProposition(int id) {
	    dao.deleteProposition(id);
	}
		
	public void editStatusOfProposition(int id, String status) {		
		dao.editStatusOfProposition(id, status);		
	}
		
	public List<Proposition> getListOfPropositionsByDirection(String direction) {
		return dao.getListOfPropositionsByDirection(direction);
	}
	

}
