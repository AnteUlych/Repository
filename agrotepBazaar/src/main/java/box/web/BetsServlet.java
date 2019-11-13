package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Message;
import box.model.Sold;

@Controller
public class BetsServlet {
	
	String WIN_BET = "bet_win";	
	String BET_WAITING = "bet_waiting";
	int AUCTON_SOLD = 4;
	
	String COORDINATOR = "coordinator";
	String TOP = "top";
	
	String EMPTY = "&nbsp;";
	
	String FIRST_PART_DELETE_BUTTON = "<button type=\"submit\" formnovalidate class=\"w3-button w3-red\" name=\"delete";
	String SECOND_PART_DELETE_BUTTON = "\" value=\"delete";
	String THIRD_PART_DELETE_BUTTON = "\" >видалити</button>";
	
	String FIRST_PART_CONFIRM_BUTTON = "<button type=\"submit\" formnovalidate class=\"w3-button w3-green\" name=\"confirm";
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
		 List<String> confirmButtons = new ArrayList();
		 List<String> deleteButtons = new ArrayList();
		 
			 
		 DataBaseController base = new DataBaseController();
		 
		 Auction auction = base.getAuctionByAuctionId(auctionid);
		 List<Bet> auctionBets = base.getListOfBetsByAuctionId(auctionid);
		 
		 base.closeConnection();
		 
		
		 if(((rank.equals(COORDINATOR)||rank.equals(TOP)))&&(auction.getImportance()!=4)){
			 deleteButton = "<button type=\"submit\" class=\"w3-button w3-red w3-quart\" name=\"deleteauction\" value=\"deleteauction\" formnovalidate >Відмінити аукціон</button>";
		 }
		 
		 for(Bet bet:auctionBets){
			 
			 if((id == bet.getManagerid())&&(auction.getImportance()!=4)){
				 deleteButtons.add(FIRST_PART_DELETE_BUTTON+bet.getId()+SECOND_PART_DELETE_BUTTON+bet.getId()+THIRD_PART_DELETE_BUTTON);
			 }else{
				 deleteButtons.add(EMPTY);
			 }
			 
			 if(rank.equals(COORDINATOR)&&(auction.getImportance()!=4)){
				 confirmButtons.add(FIRST_PART_CONFIRM_BUTTON+bet.getId()+SECOND_PART_CONFIRM_BUTTON+bet.getId()+THIRD_PART_CONFIRM_BUTTON);
			 }else{
				 confirmButtons.add(EMPTY);
			 }
		 }
		 
		 DecoderDbToHtml painter = new DecoderDbToHtml();
		 List<String> colors = painter.paintWinBet(auctionBets);
		 
		 model.addAttribute("name", name);
		 model.addAttribute("auction", auction);
		 model.addAttribute("auctionBets", auctionBets);
		 model.addAttribute("deleteButton", deleteButton);
		 
		 model.addAttribute("confirmButtons", confirmButtons);
		 model.addAttribute("deleteButtons", deleteButtons);
		 model.addAttribute("colors", colors);
		 
		return "bets";
	}
	
	@RequestMapping(value = "/bets/{idauction}", method = RequestMethod.POST)
	public String doPost(@PathVariable("idauction") String idauction,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 int auctionid = Integer.parseInt(idauction);
		 		 
		 String deleteButton = "";
		 List<String> confirmButtons = new ArrayList();
		 List<String> deleteButtons = new ArrayList();
		 
			 
		 DataBaseController base = new DataBaseController();
		 
		 Auction auction = base.getAuctionByAuctionId(auctionid);
		 List<Bet> auctionBets = base.getListOfBetsByAuctionId(auctionid);
		 
		
		 if(((rank.equals(COORDINATOR)||rank.equals(TOP)))&&(auction.getImportance()!=4)){
			 deleteButton = "<button type=\"submit\" class=\"w3-button w3-red w3-quart\" name=\"deleteauction\" formnovalidate >Відмінити</button>";
		 }
		 
		 for(Bet bet:auctionBets){
			 
			 if((id == bet.getManagerid())&&(auction.getImportance()!=4)){
				 deleteButtons.add(FIRST_PART_DELETE_BUTTON+bet.getId()+SECOND_PART_DELETE_BUTTON+bet.getId()+THIRD_PART_DELETE_BUTTON);
			 }else{
				 deleteButtons.add(EMPTY);
			 }
			 
			 if(rank.equals(COORDINATOR)&&(auction.getImportance()!=4)){
				 confirmButtons.add(FIRST_PART_CONFIRM_BUTTON+bet.getId()+SECOND_PART_CONFIRM_BUTTON+bet.getId()+THIRD_PART_CONFIRM_BUTTON);
			 }else{
				 confirmButtons.add(EMPTY);
			 }
		 }
		 
		 DecoderDbToHtml painter = new DecoderDbToHtml();
		 List<String> colors = painter.paintWinBet(auctionBets);
		 
		 model.addAttribute("name", name);
		 model.addAttribute("auction", auction);
		 model.addAttribute("auctionBets", auctionBets);
		 model.addAttribute("deleteButton", deleteButton);
		 
		 model.addAttribute("confirmButtons", confirmButtons);
		 model.addAttribute("deleteButtons", deleteButtons);
		 model.addAttribute("colors", colors);
		 
			//start Post
		 		 
		 if (request.getParameter("deleteauction") != null){
			 		 
			 Archiveauction archiveauction = new Archiveauction();
			 
			 archiveauction.setAuctionid(auctionid);
			 archiveauction.setBetcount(auction.getBetcount());
			 archiveauction.setCurrency(auction.getCurrency());
			 archiveauction.setDate(auction.getDate());
			 archiveauction.setDirection(auction.getDirection());
			 archiveauction.setImportance(auction.getImportance());
			 archiveauction.setManagerid(auction.getManagerid());
			 archiveauction.setRate(auction.getRate());
			 archiveauction.setReadiness(auction.getReadiness());
			 archiveauction.setRoute(auction.getRoute());
			 archiveauction.setTruck(auction.getTruck());
			 
			 base.addArchiveauction(archiveauction);
			 
			 for(Bet betforarchive:auctionBets){
			 
			 Archivebet archivebet = new Archivebet();
			 
			 archivebet.setAuctionid(auctionid);
			 archivebet.setBetid(betforarchive.getId());
			 archivebet.setClient(betforarchive.getClient());
			 archivebet.setCurrency(betforarchive.getCurrency());
			 archivebet.setDate(betforarchive.getDate());
			 archivebet.setDifferance(betforarchive.getDifferance());
			 archivebet.setDirection(betforarchive.getDirection());
			 archivebet.setInformation(betforarchive.getInformation());
			 archivebet.setManager(betforarchive.getManager());
			 archivebet.setManagerid(betforarchive.getManagerid());
			 archivebet.setRate(betforarchive.getRate());
			 archivebet.setReadiness(betforarchive.getReadiness());
			 archivebet.setStatus(betforarchive.getStatus());
			 
			 base.addArchivebet(archivebet);
			 base.deleteBet(betforarchive.getId());

			 }
			 
			 base.deleteAuction(auctionid);		 
			 base.closeConnection();
			 
				try {
					response.sendRedirect("/bazaar/auction");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return "auction";
			 
		 }
		 
		 for (Bet bet : auctionBets) {

				if (request.getParameter("delete" + bet.getId()) != null) {
		
					base.deleteBet(bet.getId());
					base.editBetcountOfAuction(auctionid, auction.getBetcount()-1);
					base.closeConnection();
					
					
					try {
						response.sendRedirect("/bazaar/bets/"+auction.getId());
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}

				if (request.getParameter("confirm" + bet.getId()) != null) {
										
					base.editStatusOfBet(bet.getId(), WIN_BET);
 
					Sold sold = new Sold();
					
					sold.setCurrency(auction.getCurrency());
					sold.setDate(new Date());
					sold.setDirection(auction.getDirection());
					sold.setImportance(auction.getImportance());
					sold.setInformation(bet.getInformation());
					sold.setManagerid(bet.getManagerid());
					sold.setRate(bet.getRate());
					sold.setReadiness(bet.getReadiness());
					sold.setRoute(auction.getRoute());
					sold.setTruck(auction.getTruck());	
					sold.setAuctionid(auctionid);
					sold.setBetid(bet.getId());
					sold.setManager(bet.getManager());
				
					base.addSold(sold);
					
					base.editImportanceOfAuction(auctionid, AUCTON_SOLD);
					
					//message
					Date nowDate = new Date();
					DateFormat dateFormat = new SimpleDateFormat("hh:mm");  
					String messagedate = dateFormat.format(nowDate);  
					
					String textmessage = messagedate+" напрямок "+auction.getRoute()+" виграно для клієнта "+bet.getClient()+".";
					Message message = new Message();
					message.setRecipientid(bet.getManagerid());
					message.setText(textmessage);
					base.addMessage(message);
					//message
					
					base.closeConnection();
					try {
						response.sendRedirect("/bazaar/bets/"+auction.getId());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		 
		 if (request.getParameter("addbet") != null){
			 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
		 
		 String information = request.getParameter("information");
		 String client = request.getParameter("client");
		 String readiness = request.getParameter("readiness");
		 String price = request.getParameter("price");
		 
		 int rate = Integer.parseInt(price);
		 
		 if (information != null){
				try {
					information = new String(information.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (client != null){
				try {
					client = new String(client.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (readiness != null){
				try {
					readiness = new String(readiness.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		 
	 
		 
		 int dif = rate - auction.getRate();
		 if(dif<0){
			 dif = 0;
		 }
			 
			 Bet newBet = new Bet();
			 
			 newBet.setAuctionid(auctionid);
			 newBet.setClient(client);
			 newBet.setCurrency(auction.getCurrency());
			 newBet.setDate(new Date());
			 newBet.setDifferance(dif);
			 newBet.setDirection(auction.getDirection());
			 newBet.setInformation(information);
			 newBet.setManager(name);
			 newBet.setManagerid(id);
			 newBet.setRate(rate);
			 newBet.setReadiness(readiness);
			 newBet.setStatus(BET_WAITING);
			 
			 base.addBet(newBet);
			 
			 int count = auction.getBetcount()+1;
			 
			 base.editBetcountOfAuction(auctionid, count);
			 
				base.closeConnection();
				try {
					response.sendRedirect("/bazaar/bets/"+auction.getId());
				} catch (IOException e) {
					e.printStackTrace();
				}
			 
		 }
		 base.closeConnection();
		 
		return "bets";
		
		
	}

}
