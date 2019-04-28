package lotos.service;

import java.util.List;

import lotos.dao.PropositionDAO;
import lotos.model.Proposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PropositionService")
@Transactional
public class PropositionService {
	
	@Autowired
	private PropositionDAO dao;
	//test
	public List<Proposition> getAllPropositions() {
		return dao.getAllPropositions();
	}
	//test
}
