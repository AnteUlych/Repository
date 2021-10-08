package box.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.MaplinkDAO;
import box.model.Maplink;


@Service("MaplinkService")
@Transactional
public class MaplinkService {
	
	@Autowired
	private MaplinkDAO dao;
	
	public Maplink getMaplinkById(int id) {
		return dao.getMaplinkById(id);
	}
	
	public void editMaplinkById(int id, String link) {
		dao.editMaplinkById(id, link);
	}

}
