package fsmac.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fsmac.model.Form;
import fsmac.model.Questionnaire;
import fsmac.service.FormService;
import fsmac.service.QuestionnaireService;

@Controller
@RequestMapping("/form")
public class FormController {
	
	FormService formService = new FormService();
	List<String> questions = formService.getQuestions();

	@Autowired
	@Qualifier("formValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
	
		
		Form form = new Form();
	
		form.setRate1("");
		form.setRate2("");
		form.setRate3("");
		form.setRate4("");
		form.setRate5("");
		form.setRate6("");
		form.setRate7("");
		form.setRate8("");
		form.setRate9("");
		form.setRate10("");
		model.addAttribute("form", form);
		model.addAttribute("questions", questions);
		initModelList(model);
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Form form,
			BindingResult result, HttpServletRequest request) throws UnsupportedEncodingException {
		
				   String requestEnc = "ISO-8859-1";
				   String clientEnc = request.getParameter("charset");
				   if( clientEnc==null ) clientEnc="Cp1251";
				   String name = request.getParameter("name");
				   String company = request.getParameter("company");
				   if( name!=null )
					   name = new String(name.getBytes(requestEnc),clientEnc);
				   if( company!=null )
					   company = new String(company.getBytes(requestEnc),clientEnc);
				   
				   form.setName(name);
				   form.setCompany(company);
				   
		model.addAttribute("form", form);
		model.addAttribute("questions", questions);
		String returnVal = "success";
		if (result.hasErrors()) {
			initModelList(model);
			returnVal = "form";
		} else {
			model.addAttribute("form", form);
			QuestionnaireService qs = new QuestionnaireService();
			try{
			qs.addQuestionnaire(form);
			}catch(JpaSystemException e){
				return returnVal;	
			}

		}
		return returnVal;
	}

	private void initModelList(Model model) {
		List<String> rate = new ArrayList<String>();
		rate.add("1");
		rate.add("2");
		rate.add("3");
		rate.add("4");
		rate.add("5");
		rate.add("6");
		rate.add("7");
		rate.add("8");
		rate.add("9");
		rate.add("10");
		model.addAttribute("rate1", rate);
		model.addAttribute("rate2", rate);
		model.addAttribute("rate3", rate);
		model.addAttribute("rate4", rate);
		model.addAttribute("rate5", rate);
		model.addAttribute("rate6", rate);
		model.addAttribute("rate7", rate);
		model.addAttribute("rate8", rate);
		model.addAttribute("rate9", rate);
		model.addAttribute("rate10", rate);

	}
}
