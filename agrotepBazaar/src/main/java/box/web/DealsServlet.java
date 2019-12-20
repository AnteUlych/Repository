package box.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Deal;

@Controller
public class DealsServlet {

	String DIRECTION_ALL = "all";
	String DIRECTION_IMPORT = "import";
	String DIRECTION_EXPORT = "export";

	String RANK_MANAGER = "manager";

	@RequestMapping(value = "/deals/{direction}", method = RequestMethod.GET)
	public String doGet(@PathVariable("direction") String direction,
			ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		List<Deal> deals = new ArrayList();

		String messagealert = "";

		if ((direction.equals(DIRECTION_IMPORT))
				|| (direction.equals(DIRECTION_EXPORT))) {

			DataBaseController base = new DataBaseController();

			if (rank.equals(RANK_MANAGER)) {
				deals = base.getListOfallDealsByManagerIdAndDirection(id,
						direction);
			} else {
				deals = base.getListOfallDealsByDirection(direction);
			}

			// message block
			if (base.isAnyMessagesForRecipient(id)) {
				String textmessagealert = base.getMessageByRecipientid(id)
						.getText();
				messagealert = "alert(\"" + textmessagealert + "\");";
			}
			// message block

			base.closeConnection();
		}

		if ((direction.equals(DIRECTION_ALL))) {

			DataBaseController base = new DataBaseController();

			if (rank.equals(RANK_MANAGER)) {
				deals = base.getListOfallDealsByManagerId(id);
			} else {
				deals = base.getListOfallDeals();
			}

			// message block
			if (base.isAnyMessagesForRecipient(id)) {
				String textmessagealert = base.getMessageByRecipientid(id)
						.getText();
				messagealert = "alert(\"" + textmessagealert + "\");";
				base.deleteMessage(base.getMessageByRecipientid(id).getId());
			}
			// message block

			base.closeConnection();
		}

		DecoderDbToHtml translateToHtml = new DecoderDbToHtml();

		// List<String> colors = translateToHtml.paintDeals(deals);
		// List<String> dates = translateToHtml.getDatesForHtmlDates(deals);

		model.addAttribute("messagealert", messagealert);

		// new calendar
		Date today = new Date();
		Calendar cal = Calendar.getInstance();

		cal.setTime(today);
		int presentWeek = cal.get(Calendar.WEEK_OF_YEAR);

		cal.add(Calendar.DAY_OF_YEAR, -7);
		int lastWeek = cal.get(Calendar.WEEK_OF_YEAR);

		cal.add(Calendar.DAY_OF_YEAR, 14);
		int nextWeek = cal.get(Calendar.WEEK_OF_YEAR);

		List<Deal> lastWeekMomday = new ArrayList();
		List<Deal> lastWeekTuesday = new ArrayList();
		List<Deal> lastWeekWednesday = new ArrayList();
		List<Deal> lastWeekThursday = new ArrayList();
		List<Deal> lastWeekFriday = new ArrayList();
		List<Deal> lastWeekSaturday = new ArrayList();
		List<Deal> lastWeekSunday = new ArrayList();

		List<Deal> presentWeekMomday = new ArrayList();
		List<Deal> presentWeekTuesday = new ArrayList();
		List<Deal> presentWeekWednesday = new ArrayList();
		List<Deal> presentWeekThursday = new ArrayList();
		List<Deal> presentWeekFriday = new ArrayList();
		List<Deal> presentWeekSaturday = new ArrayList();
		List<Deal> presentWeekSunday = new ArrayList();

		List<Deal> nextWeekMomday = new ArrayList();
		List<Deal> nextWeekTuesday = new ArrayList();
		List<Deal> nextWeekWednesday = new ArrayList();
		List<Deal> nextWeekThursday = new ArrayList();
		List<Deal> nextWeekFriday = new ArrayList();
		List<Deal> nextWeekSaturday = new ArrayList();
		List<Deal> nextWeekSunday = new ArrayList();

		for (Deal deal : deals) {

			Date transportdate = deal.getDateoftransportation();
			cal.setTime(transportdate);

			int transportWeek = cal.get(Calendar.WEEK_OF_YEAR);
			int transportDay = cal.get(Calendar.DAY_OF_WEEK);

			if (presentWeek == transportWeek) {

				if (transportDay == 1) {
					presentWeekSunday.add(deal);
				}

				if (transportDay == 2) {
					presentWeekMomday.add(deal);
				}

				if (transportDay == 3) {
					presentWeekTuesday.add(deal);
				}

				if (transportDay == 4) {
					presentWeekWednesday.add(deal);
				}

				if (transportDay == 5) {
					presentWeekThursday.add(deal);
				}

				if (transportDay == 6) {
					presentWeekFriday.add(deal);
				}

				if (transportDay == 7) {
					presentWeekSaturday.add(deal);
				}

			} 
			if (lastWeek == transportWeek) {
				if (transportDay == 1) {
					lastWeekSunday.add(deal);
				}

				if (transportDay == 2) {
					lastWeekMomday.add(deal);
				}

				if (transportDay == 3) {
					lastWeekTuesday.add(deal);
				}

				if (transportDay == 4) {
					lastWeekWednesday.add(deal);
				}

				if (transportDay == 5) {
					lastWeekThursday.add(deal);
				}

				if (transportDay == 6) {
					lastWeekFriday.add(deal);
				}

				if (transportDay == 7) {
					lastWeekSaturday.add(deal);
				} 
			}
				if (nextWeek == transportWeek) {
					if (transportDay == 1) {
						nextWeekSunday.add(deal);
					}

					if (transportDay == 2) {
						nextWeekMomday.add(deal);
					}

					if (transportDay == 3) {
						nextWeekTuesday.add(deal);
					}

					if (transportDay == 4) {
						nextWeekWednesday.add(deal);
					}

					if (transportDay == 5) {
						nextWeekThursday.add(deal);
					}

					if (transportDay == 6) {
						nextWeekFriday.add(deal);
					}

					if (transportDay == 7) {
						nextWeekSaturday.add(deal);
					}
				}

			}
		
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		String presentSunday = getDateInString(year, presentWeek, 1);
		String presentMonday = getDateInString(year, presentWeek, 2);
		String presentTuesday = getDateInString(year, presentWeek, 3);
		String presentWednesday = getDateInString(year, presentWeek, 4);
		String presentThursday = getDateInString(year, presentWeek, 5);
		String presentFriday = getDateInString(year, presentWeek, 6);
		String presentSaturday = getDateInString(year, presentWeek, 7);
							
		String lastSunday = getDateInString(year, lastWeek, 1);
		String lastMonday = getDateInString(year, lastWeek, 2);
		String lastTuesday = getDateInString(year, lastWeek, 3);
		String lastWednesday = getDateInString(year, lastWeek, 4);
		String lastThursday = getDateInString(year, lastWeek, 5);
		String lastFriday = getDateInString(year, lastWeek, 6);
		String lastSaturday = getDateInString(year, lastWeek, 7);
		
		String nextSunday = getDateInString(year, nextWeek, 1);
		String nextMonday = getDateInString(year, nextWeek, 2);
		String nextTuesday = getDateInString(year, nextWeek, 3);
		String nextWednesday = getDateInString(year, nextWeek, 4);
		String nextThursday = getDateInString(year, nextWeek, 5);
		String nextFriday = getDateInString(year, nextWeek, 6);
		String nextSaturday = getDateInString(year, nextWeek, 7);
	
	
		List<String> lastWeekMomdayColors = translateToHtml.paintDeals(lastWeekMomday);
		List<String> lastWeekTuesdayColors = translateToHtml.paintDeals(lastWeekTuesday);
		List<String> lastWeekWednesdayColors = translateToHtml.paintDeals(lastWeekWednesday);
		List<String> lastWeekThursdayColors = translateToHtml.paintDeals(lastWeekThursday);
		List<String> lastWeekFridayColors = translateToHtml.paintDeals(lastWeekFriday);
		List<String> lastWeekSaturdayColors = translateToHtml.paintDeals(lastWeekSaturday);
		List<String> lastWeekSundayColors = translateToHtml.paintDeals(lastWeekSunday);
		
		List<String> presentWeekMomdayColors = translateToHtml.paintDeals(presentWeekMomday);
		List<String> presentWeekTuesdayColors = translateToHtml.paintDeals(presentWeekTuesday);
		List<String> presentWeekWednesdayColors = translateToHtml.paintDeals(presentWeekWednesday);
		List<String> presentWeekThursdayColors = translateToHtml.paintDeals(presentWeekThursday);
		List<String> presentWeekFridayColors = translateToHtml.paintDeals(presentWeekFriday);
		List<String> presentWeekSaturdayColors = translateToHtml.paintDeals(presentWeekSaturday);
		List<String> presentWeekSundayColors = translateToHtml.paintDeals(presentWeekSunday);
		
		List<String> nextWeekMomdayColors = translateToHtml.paintDeals(nextWeekMomday);
		List<String> nextWeekTuesdayColors = translateToHtml.paintDeals(nextWeekTuesday);
		List<String> nextWeekWednesdayColors = translateToHtml.paintDeals(nextWeekWednesday);
		List<String> nextWeekThursdayColors = translateToHtml.paintDeals(nextWeekThursday);
		List<String> nextWeekFridayColors = translateToHtml.paintDeals(nextWeekFriday);
		List<String> nextWeekSaturdayColors = translateToHtml.paintDeals(nextWeekSaturday);
		List<String> nextWeekSundayColors = translateToHtml.paintDeals(nextWeekSunday);
		
		//List<String> dates = translateToHtml.getDatesForHtmlDates(deals);

		// new calendar

		model.addAttribute("name", name);

		model.addAttribute("nextSunday", nextSunday);
		model.addAttribute("nextMonday", nextMonday);
		model.addAttribute("nextTuesday", nextTuesday);
		model.addAttribute("nextWednesday", nextWednesday);
		model.addAttribute("nextThursday", nextThursday);
		model.addAttribute("nextFriday", nextFriday);
		model.addAttribute("nextSaturday", nextSaturday);
		
		model.addAttribute("lastSunday", lastSunday);
		model.addAttribute("lastMonday", lastMonday);
		model.addAttribute("lastTuesday", lastTuesday);
		model.addAttribute("lastWednesday", lastWednesday);
		model.addAttribute("lastThursday", lastThursday);
		model.addAttribute("lastFriday", lastFriday);
		model.addAttribute("lastSaturday", lastSaturday);
		
		
		model.addAttribute("presentSunday", presentSunday);
		model.addAttribute("presentMonday", presentMonday);
		model.addAttribute("presentTuesday", presentTuesday);
		model.addAttribute("presentWednesday", presentWednesday);
		model.addAttribute("presentThursday", presentThursday);
		model.addAttribute("presentFriday", presentFriday);
		model.addAttribute("presentSaturday", presentSaturday);
		
	
		model.addAttribute("lastWeekMomdayColors", lastWeekMomdayColors);
		model.addAttribute("lastWeekTuesdayColors", lastWeekTuesdayColors);
		model.addAttribute("lastWeekWednesdayColors", lastWeekWednesdayColors);
		model.addAttribute("lastWeekThursdayColors", lastWeekThursdayColors);
		model.addAttribute("lastWeekFridayColors", lastWeekFridayColors);
		model.addAttribute("lastWeekSaturdayColors", lastWeekSaturdayColors);
		model.addAttribute("lastWeekSundayColors", lastWeekSundayColors);
		
		model.addAttribute("presentWeekMomdayColors", presentWeekMomdayColors);
		model.addAttribute("presentWeekTuesdayColors", presentWeekTuesdayColors);
		model.addAttribute("presentWeekWednesdayColors", presentWeekWednesdayColors);
		model.addAttribute("presentWeekThursdayColors", presentWeekThursdayColors);
		model.addAttribute("presentWeekFridayColors", presentWeekFridayColors);
		model.addAttribute("presentWeekSaturdayColors", presentWeekSaturdayColors);
		model.addAttribute("presentWeekSundayColors", presentWeekSundayColors);
		
		model.addAttribute("nextWeekMomdayColors", nextWeekMomdayColors);
		model.addAttribute("nextWeekTuesdayColors", nextWeekTuesdayColors);
		model.addAttribute("nextWeekWednesdayColors", nextWeekWednesdayColors);
		model.addAttribute("nextWeekThursdayColors", nextWeekThursdayColors);
		model.addAttribute("nextWeekFridayColors", nextWeekFridayColors);
		model.addAttribute("nextWeekSaturdayColors", nextWeekSaturdayColors);
		model.addAttribute("nextWeekSundayColors", nextWeekSundayColors);
		
		model.addAttribute("lastWeekMomday", lastWeekMomday);
		model.addAttribute("lastWeekTuesday", lastWeekTuesday);
		model.addAttribute("lastWeekWednesday", lastWeekWednesday);
		model.addAttribute("lastWeekThursday", lastWeekThursday);
		model.addAttribute("lastWeekFriday", lastWeekFriday);
		model.addAttribute("lastWeekSaturday", lastWeekSaturday);
		model.addAttribute("lastWeekSunday", lastWeekSunday);
		
		model.addAttribute("presentWeekMomday", presentWeekMomday);
		model.addAttribute("presentWeekTuesday", presentWeekTuesday);
		model.addAttribute("presentWeekWednesday", presentWeekWednesday);
		model.addAttribute("presentWeekThursday", presentWeekThursday);
		model.addAttribute("presentWeekFriday", presentWeekFriday);
		model.addAttribute("presentWeekSaturday", presentWeekSaturday);
		model.addAttribute("presentWeekSunday", presentWeekSunday);
		
		model.addAttribute("nextWeekMomday", nextWeekMomday);
		model.addAttribute("nextWeekTuesday", nextWeekTuesday);
		model.addAttribute("nextWeekWednesday", nextWeekWednesday);
		model.addAttribute("nextWeekThursday", nextWeekThursday);
		model.addAttribute("nextWeekFriday", nextWeekFriday);
		model.addAttribute("nextWeekSaturday", nextWeekSaturday);
		model.addAttribute("nextWeekSunday", nextWeekSunday);
			
		// model.addAttribute("deals", deals);
		// model.addAttribute("colors", colors);
		// model.addAttribute("dates", dates);

		return "deals";
	}

	private String getDateInString(int year, int weekOfYear, int dayOfWeek){
		
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        
        Date date = cal.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM");
        String dateString = dateFormat.format(date);
        
        String resultWeek = "";
        
        if(dayOfWeek==1){
        	resultWeek = "нед≥л€, ";
        }else if(dayOfWeek==2){
        	resultWeek = "понед≥лок, ";
        }else if(dayOfWeek==3){
        	resultWeek = "в≥второк, ";
        }else if(dayOfWeek==4){
        	resultWeek = "середа, ";
        }else if(dayOfWeek==5){
        	resultWeek = "четвер, ";
        }else if(dayOfWeek==6){
        	resultWeek = "п'€тниц€, ";
        }else if(dayOfWeek==7){
        	resultWeek = "суббота, ";
        }
		
		return resultWeek+dateString;
	}

}
