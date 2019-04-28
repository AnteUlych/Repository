package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Statistic;

import org.springframework.stereotype.Repository;

@Repository
public class StatisticDAO {

	@PersistenceContext
	private EntityManager em;
	
	//test
	@SuppressWarnings("unchecked")
	public List<Statistic> getAllStatistic() {
		return em
				.createQuery("from Statistic")
				.getResultList();
	}
	//test
}
