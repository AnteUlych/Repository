package racoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import racoon.dao.PropositionDAO;
import racoon.model.Proposition;

@Service("PropositionService")
@Transactional
public class PropositionService {

	@Autowired
	private PropositionDAO dao;
	
	public void addProposition(Proposition proposition) {
		dao.persist(proposition);
	}
	
	public List<Proposition> getAllPropositionsByRequest(int idRequest) {
		return dao.getAllPropositionsByRequest(idRequest);
	}
	
	public void deleteProposition(int id){
		dao.deleteProposition(id);
	}
	
	public void desideProposition(int id, String result) {
		dao.desideProposition(id, result);
	}
}
