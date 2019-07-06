package lotos.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.NoResultException;

import lotos.model.Deal;

public class SimpleLogic {
	
	public List<Deal> getDealsByIdWithNoRecommendation(int companyid){
		
		DataController dc = new DataController();
		
		List<Deal> deals = dc.getDealsByCompanyOrPropositionId(companyid, companyid);
		List<Deal> notRecommendedDeals = new ArrayList();
		
		for(Deal deal:deals){
			
			if(!isRecommendationExist(deal.getId())){
				notRecommendedDeals.add(deal);
			}
			
		}
		dc.closeConnection();
		return notRecommendedDeals;
	}
	
	public boolean isRecommendationExist(int dealid){
		
		DataController dc = new DataController();
		
		try {
			
			dc.getRecomendationByDealId(dealid);
			dc.closeConnection();
			return true;
			
			}catch(NoResultException e) {
			 
				dc.closeConnection();
				return false;
			}
	}
	
	public String fixDateInString(){
		
		String pattern = "HH:mm MM.dd.yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);
		
		return todayAsString;
		
	}
	
        public Date convertStringToDate(String string){
        	try {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(string);
	
		return date;
        	} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			return new Date();
	}

}
