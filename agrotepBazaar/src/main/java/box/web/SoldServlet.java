package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
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
import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;
import box.model.Message;
import box.model.Sold;

@Controller
@RequestMapping("/sold")
public class SoldServlet {

	String EMPTY = "&nbsp;";

	String BET_WIN = "bet_win";
	String BET_LOST = "bet_lost";

	String TOP = "top";
	String COORDINATOR = "coordinator";
	String MANAGER = "manager";

	String BUTTON_BEFORE_ID = "<button class=\"w3-button\" onclick=\"document.getElementById('subscribe";
	String BUTTON_AFTER_ID = "').style.display='block'\"><i class=\"fa fa-truck\"></i></button>";

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		List<Sold> solds = new ArrayList();
		List<String> buttons = new ArrayList();

		DataBaseController base = new DataBaseController();

		if ((rank.equals(COORDINATOR)) || (rank.equals(TOP))) {
			solds = base.getListOfAllSold();

			for (Sold sold : solds) {

				if (id == sold.getManagerid()) {
					buttons.add(BUTTON_BEFORE_ID + sold.getId()
							+ BUTTON_AFTER_ID);
				} else {
					buttons.add(EMPTY);
				}
			}
		}

		if (rank.equals(MANAGER)) {
			solds = base.getListOfSoldByManagerId(id);

			for (Sold sold : solds) {
				buttons.add(BUTTON_BEFORE_ID + sold.getId() + BUTTON_AFTER_ID);
			}
		}

		base.closeConnection();

		session.setAttribute("name", name);
		session.setAttribute("solds", solds);
		session.setAttribute("buttons", buttons);

		return "sold";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		List<Sold> solds = new ArrayList();
		List<String> buttons = new ArrayList();

		DataBaseController base = new DataBaseController();

		if ((rank.equals(COORDINATOR)) || (rank.equals(TOP))) {
			solds = base.getListOfAllSold();

			for (Sold sold : solds) {

				if (id == sold.getManagerid()) {
					buttons.add(BUTTON_BEFORE_ID + sold.getId()
							+ BUTTON_AFTER_ID);
				} else {
					buttons.add(EMPTY);
				}
			}
		}

		if (rank.equals(MANAGER)) {
			solds = base.getListOfSoldByManagerId(id);

			for (Sold sold : solds) {
				buttons.add(BUTTON_BEFORE_ID + sold.getId() + BUTTON_AFTER_ID);
			}
		}

		session.setAttribute("name", name);
		session.setAttribute("solds", solds);
		session.setAttribute("buttons", buttons);

		// start Post

		for (Sold sol : solds) {

			if (request.getParameter("cancel" + sol.getId()) != null) {
				
				//message
				Date nowDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("hh:mm");  
				String messagedate = dateFormat.format(nowDate);  
				
				String textmessage = messagedate+" "+sol.getManager()+": скасування броні на машину по напрямку "+sol.getRoute()+".";
				Message message = new Message();
				int recipientid = base.getAuctionByAuctionId(sol.getAuctionid()).getManagerid();
				message.setRecipientid(recipientid);
				message.setText(textmessage);
				base.addMessage(message);
				//message

				base.editImportanceOfAuction(sol.getAuctionid(),
						sol.getImportance());
				int countOfBetInAuction = base.getAuctionByAuctionId(
						sol.getAuctionid()).getBetcount() - 1;
				base.editBetcountOfAuction(sol.getAuctionid(),
						countOfBetInAuction);
				base.deleteBet(sol.getBetid());
				base.deleteSold(sol.getId());

				base.closeConnection();

				try {
					response.sendRedirect("/tender/auction");
				} catch (IOException e) {
					e.printStackTrace();
				}

				return "auction";
			}

			if (request.getParameter("toDeals" + sol.getId()) != null) {

				String stringDate = request.getParameter("readydate"
						+ sol.getId());
				String truck = request.getParameter("truck" + sol.getId());
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
				
				if (truck != null){
					try {
						truck = new String(truck.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

				DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //changed bug of mounth
				Date dateoftransportation = null;

				try {
					dateoftransportation = format.parse(stringDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				Deal deal = new Deal();

				deal.setDate(new Date());
				deal.setDateoftransportation(dateoftransportation);
				deal.setDirection(sol.getDirection());
				deal.setInformation(sol.getInformation());
				deal.setManager(name);
				deal.setManagerid(sol.getManagerid());
				deal.setRoute(sol.getRoute());
				deal.setSoldid(sol.getId());
				deal.setStatus("deal_waiting");
				deal.setTruck(truck);
				deal.setTruckdriver("");
				deal.setBetid(sol.getBetid());
				deal.setOtherinformation("");
				
				//change with adding chiefs table
				deal.setChiefid(0);
				deal.setChiefname("");
				//change

				base.addDeal(deal);

				Archiveauction archiveauction = new Archiveauction();

				Auction auction = base
						.getAuctionByAuctionId(sol.getAuctionid());

				archiveauction.setAuctionid(auction.getId());
				archiveauction.setBetcount(auction.getBetcount());
				archiveauction.setCurrency(auction.getCurrency());
				archiveauction.setDate(auction.getDate());
				archiveauction.setDirection(auction.getDirection());
				archiveauction.setImportance(sol.getImportance()); //changed without checking  from auction.getImportance()
				archiveauction.setManagerid(auction.getManagerid());
				archiveauction.setRate(auction.getRate());
				archiveauction.setReadiness(auction.getReadiness());
				archiveauction.setRoute(auction.getRoute());
				archiveauction.setTruck(auction.getTruck());

				base.addArchiveauction(archiveauction);

				List<Bet> bets = base.getListOfBetsByAuctionId(auction.getId());

				for (Bet bet : bets) {

					Archivebet archivebet = new Archivebet();

					archivebet.setAuctionid(bet.getAuctionid());
					archivebet.setBetid(bet.getId());
					archivebet.setClient(bet.getClient());
					archivebet.setCurrency(bet.getCurrency());
					archivebet.setDate(bet.getDate());
					archivebet.setDifferance(bet.getDifferance());
					archivebet.setDirection(bet.getDirection());
					archivebet.setInformation(bet.getInformation());
					archivebet.setManager(bet.getManager());
					archivebet.setManagerid(bet.getManagerid());
					archivebet.setRate(bet.getRate());
					archivebet.setReadiness(bet.getReadiness());
					

					if (sol.getBetid() == bet.getId()) {
						archivebet.setStatus(BET_WIN);
					} else {
						archivebet.setStatus(BET_LOST);
					}

					base.addArchivebet(archivebet);
					base.deleteBet(bet.getId());
				}

				base.deleteAuction(auction.getId());
				base.deleteSold(sol.getId());

				base.closeConnection();

				try {
					response.sendRedirect("/tender/deals/all");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "deals";
			}

		}

		base.closeConnection();
		return "sold";
	}

}
