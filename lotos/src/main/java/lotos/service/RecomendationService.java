package lotos.service;

import java.util.List;

import lotos.dao.RecomendationDAO;
import lotos.model.Recomendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RecomendationService")
@Transactional
public class RecomendationService {

	@Autowired
	private RecomendationDAO dao;
	//test
	public List<Recomendation> getAllRecomendations() {
		return dao.getAllRecomendations();
	}
	//test
}
