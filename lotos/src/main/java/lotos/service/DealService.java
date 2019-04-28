package lotos.service;

import java.util.List;

import lotos.dao.DealDAO;
import lotos.model.Deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("DealService")
@Transactional
public class DealService {
	@Autowired
	private DealDAO dao;
	//test
	public List<Deal> getAllDeals() {
		return dao.getAllDeals();
	}
	//test
}
