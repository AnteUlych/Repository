package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Auction;
import box.model.Bet;

@Controller
public class BetsServlet {
	
	String COORDINATOR = "coordinator";
	String TOP = "top";
	
	String EMPTY = "&nbsp;";
	
	String FIRST_PART_DELETE_BUTTON = "<button type=\"submit\" class=\"w3-button w3-red\" name=\"delete";
	String SECOND_PART_DELETE_BUTTON = "\" value=\"cancel";
	String THIRD_PART_DELETE_BUTTON = "\" >видалити</button>";
	
	String FIRST_PART_CONFIRM_BUTTON = "<button type=\"submit\" class=\"w3-button w3-green\" name=\"confirm";
	String SECOND_PART_CONFIRM_BUTTON = "\" value=\"confirm";
	String THIRD_PART_CONFIRM_BUTTON = "\" >підтвердити</button>";
	
	@RequestMapping(value = "/bets/{idauction}", method = RequestMethod.GET)
	public String doGet(@PathVariable("idauction") String idauction,
			ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 int auctionid = Integer.parseInt(idauction);
		 
		 String deleteButton = "";
		 if(rank.equals(COORDINATOR)||rank.equals(COORDINATOR)){
			 deleteButton = "<button class=\"w3-button w3-red w3-quart\" >Відмінити</button>";
		 }
		 
		 List<String> confirmButtons = new ArrayList();
		 List<String> deleteButtons = new ArrayList();
	
		 
		 DataBaseController base = new DataBaseController();
		 
		 Auction auction = base.getAuctionByAuctionId(auctionid);
		 List<Bet> auctionBets = base.getListOfBetsByAuctionId(auctionid);
		 
		 base.closeConnection();
		 
		 for(Bet bet:auctionBets){
			 
			 if(id == bet.getManagerid()){
				 deleteButtons.add(FIRST_PART_DELETE_BUTTON+bet.getId()+SECOND_PART_DELETE_BUTTON+bet.getId()+THIRD_PART_DELETE_BUTTON);
			 }else{
				 deleteButtons.add(EMPTY);
			 }
			 
			 if(rank.equals(COORDINATOR)){
				 confirmButtons.add(FIRST_PART_CONFIRM_BUTTON+bet.getId()+SECOND_PART_CONFIRM_BUTTON+bet.getId()+THIRD_PART_CONFIRM_BUTTON);
			 }else{
				 confirmButtons.add(EMPTY);
			 }
		 }
		 
		 model.addAttribute("name", name);
		 model.addAttribute("auction", auction);
		 model.addAttribute("auctionBets", auctionBets);
		 model.addAttribute("deleteButton", deleteButton);
		 
		 model.addAttribute("confirmButtons", confirmButtons);
		 model.addAttribute("deleteButtons", deleteButtons);
		 
		return "bets";
	}

}
