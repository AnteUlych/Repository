package fsmac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fsmac.model.Questionnaire;

@Repository
public class QuestionnaireDAO {

	@PersistenceContext
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Questionnaire> getAllQuestionnaires() {
		return em.createQuery("from questionnaire q").getResultList();

	}
	
	@Transactional
	public void add(Questionnaire questionnaire) {
		Questionnaire form = em.merge(questionnaire);
		em.persist(form);
		em.close();
	}
	
	public Number getTheRateBy(String column) {

		Query query = em
				.createQuery("select sum("+column+") from questionnaire");

		return (Number) query.getSingleResult();
	}
	
	public Number getTheCountOfForms(){
		Query query = em
				.createQuery("select count(id) from questionnaire");
		return (Number) query.getSingleResult();
	}
}
