package fsmac.toster;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fsmac.dao.QuestionnaireDAO;
import fsmac.model.Form;
import fsmac.model.Questionnaire;
import fsmac.service.FormService;
import fsmac.service.QuestionnaireService;


public class Toster {

	public static void main(String[] args) {
	
	//	QuestionnaireService qs = new QuestionnaireService();
	/**
		Form f = new Form();
		
		f.setCompany("Congo Ltd");
		f.setName("ms Jane");
		f.setRate2("10");
		f.setRate3("9");
		f.setRate4("9");
		f.setRate5("9");
		f.setRate6("9");
		f.setRate7("10");
		f.setRate8("10");
		f.setRate9("10");
		f.setRate10("10");
		f.setRate1("10");
		
		qs.addQuestionnaire(f);
		
		List<Questionnaire> list = qs.getAllQuestionnaires();
		System.out.println(list.get(1).getDate());
		*/
	//	qd.add(q);
		
		
		
		//System.out.println(qd.getTheRateBy("question1"));
		//System.out.println(qd.getTheCountOfForms());
		
		FormService f = new FormService();
		List<String> l = f.getQuestions();
		for(String li:l){
			System.out.println(li);
		}
	}

}
