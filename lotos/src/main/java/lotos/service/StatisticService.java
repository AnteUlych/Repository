package lotos.service;

import java.util.List;

import lotos.dao.StatisticDAO;
import lotos.model.Statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("StatisticService")
@Transactional
public class StatisticService {

	@Autowired
	private StatisticDAO dao;
	//test
	public List<Statistic> getAllStatistics() {
		return dao.getAllStatistic();
	}
	//test
}
