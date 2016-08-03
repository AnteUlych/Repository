package fsmac.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fsmac.dao.QuestionnaireDAO;
import fsmac.model.Form;
import fsmac.model.Questionnaire;

public class QuestionnaireService {

	public static final int NUMBER_OF_QUESTIONS = 10;

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring-context.xml");
	QuestionnaireDAO dao = (QuestionnaireDAO) ctx.getBean("questionnaireDAO");

	public List<Questionnaire> getAllQuestionnaires() {
		List<Questionnaire> list = dao.getAllQuestionnaires();
		return list;
	}

	public void addQuestionnaire(Form form) {

		Questionnaire questionnaire = new Questionnaire();

		questionnaire.setName(form.getName());
		questionnaire.setCompany(form.getCompany());

		questionnaire.setQuestion1(translateRateToNumber(form.getRate1()));
		questionnaire.setQuestion2(translateRateToNumber(form.getRate2()));
		questionnaire.setQuestion3(translateRateToNumber(form.getRate3()));
		questionnaire.setQuestion4(translateRateToNumber(form.getRate4()));
		questionnaire.setQuestion5(translateRateToNumber(form.getRate5()));
		questionnaire.setQuestion6(translateRateToNumber(form.getRate6()));
		questionnaire.setQuestion7(translateRateToNumber(form.getRate7()));
		questionnaire.setQuestion8(translateRateToNumber(form.getRate8()));
		questionnaire.setQuestion9(translateRateToNumber(form.getRate9()));
		questionnaire.setQuestion10(translateRateToNumber(form.getRate10()));

		questionnaire.setRegistration(new Date());

		dao.add(questionnaire);
	}

	private int translateRateToNumber(String rate) {
		int result = Integer.parseInt(rate);
		return result;
	}


	public List<String> getTotalRates() {
		double number = dao.getTheCountOfForms().doubleValue();
		List<String> list = new ArrayList<>();
		list.add("total");
		double total=0;
		double result;
		for(int index = 1; index<=NUMBER_OF_QUESTIONS; index++ ){
			Number rate = dao.getTheRateBy("question"+index);
			result = (rate.doubleValue())/number;
			total = total+ result;
			list.add(String.format("%.1f", result));
		}
		
		list.set(0, String.format("%.1f", total)+"%");
		return list;
	}
}
