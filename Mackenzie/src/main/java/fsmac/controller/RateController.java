package fsmac.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fsmac.model.Rate;

@Controller
@RequestMapping("/rate.htm")
public class RateController {
	
private static final int DIFFERENCE = 150; //magic number for demo version need to be changed
    @Autowired
    @Qualifier("rateValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Rate rate = new Rate();

		model.addAttribute("rate", rate);
		initModelList(model);
		return "rate";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Rate rate, BindingResult result) {
		model.addAttribute("rate", rate);
		String returnVal = "success";
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "rate";
		} else {
		
			initModelList(model);
			returnVal = "rate";
			
			int randomRate = calculateRate();
			
			String consolidateRate = ""+randomRate;
			String separateRate = ""+(randomRate+DIFFERENCE);
			String odessaRate = ""+(randomRate-DIFFERENCE);
			
			model.addAttribute("rate", rate);
			
			model.addAttribute("consolidateRate", consolidateRate);
			model.addAttribute("separateRate", separateRate);
			model.addAttribute("odessaRate", odessaRate);
			
		}		
		return returnVal;
	}


	private void initModelList(Model model) {
		List<String> weight = new ArrayList<String>();
		weight.add("0.1 - 0.5");
		weight.add("0.5 - 1.0");
		weight.add("1.0 - 1.5");
		weight.add("1.5 - 2.5");
		weight.add("2.5 - 3.5");
		weight.add("3.5 - 4.5");
		weight.add("6.5 - 8.5");
		weight.add("8.5 - 10.0");
		
		
		List<String> volume = new ArrayList<String>();
		volume.add("1 - 5");
		volume.add("5 - 15");
		volume.add("15 - 25");
		volume.add("25 - 35");
		volume.add("35 - 45");
		volume.add("45 - 55");

		List<String> port = new ArrayList<String>();
		port.add("Fujian");
		port.add("Guangdong");
		port.add("Hainan");
		port.add("Hebei");
		port.add("Hong Kong");
		port.add("Jiangsu");
		port.add("Liaoning");
		port.add("Shanghai");
		port.add("Tianjin");
		
		List<String> city = new ArrayList<String>();
		city.add("Kyiv");
		city.add("Lviv");
		city.add("Kharkiv");
		city.add("Ivano-Frankivsk");
		
	
		model.addAttribute("weight", weight);
		model.addAttribute("volume", volume);
		model.addAttribute("port", port);
		model.addAttribute("city", city);
	}
	

	private int calculateRate() {//method for demo version need to be changed
		Random rand = new Random();
		int  randomResult = rand.nextInt(1500) + 500; //magic numbers for demo version need to be changed
		return randomResult;
	}
}
