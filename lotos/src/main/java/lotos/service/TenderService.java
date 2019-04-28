package lotos.service;

import java.util.List;

import lotos.dao.TenderDAO;
import lotos.model.Tender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("TenderService")
@Transactional
public class TenderService {

	@Autowired
	private TenderDAO dao;
	//test
	public List<Tender> getAllTenders() {
		return dao.getAllTenders();
	}
	//test
}
