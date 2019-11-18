package box.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;

public class DecoderDbToHtml {
	
	String IMPORTANCE_1 = "fa fa-bomb w3-text-black w3-large";
	String IMPORTANCE_2 = "fa fa-bolt w3-text-yellow w3-large";
	String IMPORTANCE_3 = "fa fa fa-dot-circle-o w3-text-blue w3-large";
	String IMPORTANCE_4 = "fa fa-umbrella w3-text-black w3-large";
	
	String IMPORTANCE_1_COLOR = "w3-red";
	String IMPORTANCE_4_COLOR = "w3-gray";
	String NO_COLOR = "";
		
	String WIN_BET = "bet_win";
	String WIN_BET_COLOR = "w3-lime";
	
	String COLOR_DEAL_WAITING = "";
	String COLOR_DEAL_OK = "w3-green";
	String COLOR_DEAL_CANCELED = "w3-red";
	
	String DEAL_WAITING = "deal_waiting";
	String DEAL_OK = "deal_ok";
	String DEAL_CANCELED = "deal_canceled";
	
	public List<String> getDatesForHtmlDates(List<Deal> deals){
		
		List<String> dates = new ArrayList();		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");  
		
		for(Deal deal:deals){
			
			dates.add(formatter.format(deal.getDateoftransportation()));
			
		}
		
		return dates;
		
	}
	
	public List<String> getDatesForHtmlDatesForArchive(List<Archiveauction> auctions){
		
		List<String> dates = new ArrayList();		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");  
		
		for(Archiveauction auction:auctions){
			
			dates.add(formatter.format(auction.getDate()));
			
		}
		
		return dates;
		
	}
	
	public List<String> paintDeals(List<Deal> deals){
		
		List<String> colors = new ArrayList();
		
		for(Deal deal:deals){
			
			if(deal.getStatus().equals(DEAL_WAITING)){
				colors.add(COLOR_DEAL_WAITING);
			}
			
			if(deal.getStatus().equals(DEAL_OK)){
				colors.add(COLOR_DEAL_OK);
			}
			
			if(deal.getStatus().equals(DEAL_CANCELED)){
				colors.add(COLOR_DEAL_CANCELED);
			}
			
		}
		
		return colors;
	}
	
public List<String> colourTranslateAuctionStatusAndImportanceToJsp(List<Auction> auctions){
		
		List<String> colors = new ArrayList();
		
		for(Auction auction:auctions){
			
			if(auction.getImportance()==1){
				colors.add(IMPORTANCE_1_COLOR);
			}
			if(auction.getImportance()==2){
				colors.add(NO_COLOR);
			}
			if(auction.getImportance()==3){
				colors.add(NO_COLOR);
			}
			if(auction.getImportance()==4){
				colors.add(IMPORTANCE_4_COLOR);
			}
			
		}
		
		return colors;
	}

public List<String> translateArchiveauctionStatusAndImportanceToJsp(List<Archiveauction> auctions){
	
	List<String> icons = new ArrayList();
	
	for(Archiveauction auction:auctions){
		
		if(auction.getImportance()==1){
			icons.add(IMPORTANCE_1);
		}
		if(auction.getImportance()==2){
			icons.add(IMPORTANCE_2);
		}
		if(auction.getImportance()==3){
			icons.add(IMPORTANCE_3);
		}
		if(auction.getImportance()==4){
			icons.add(IMPORTANCE_4);
		}
		
	}
	
	return icons;
}
	
	public List<String> translateAuctionStatusAndImportanceToJsp(List<Auction> auctions){
		
		List<String> icons = new ArrayList();
		
		for(Auction auction:auctions){
			
			if(auction.getImportance()==1){
				icons.add(IMPORTANCE_1);
			}
			if(auction.getImportance()==2){
				icons.add(IMPORTANCE_2);
			}
			if(auction.getImportance()==3){
				icons.add(IMPORTANCE_3);
			}
			if(auction.getImportance()==4){
				icons.add(IMPORTANCE_4);
			}
			
		}
		
		return icons;
	}
	
public List<String> translateArchiveAuctionStatusAndImportanceToJsp(List<Archiveauction> auctions){
		
		List<String> icons = new ArrayList();
		
		for(Archiveauction auction:auctions){
			
			if(auction.getImportance()==1){
				icons.add(IMPORTANCE_1);
			}
			if(auction.getImportance()==2){
				icons.add(IMPORTANCE_2);
			}
			if(auction.getImportance()==3){
				icons.add(IMPORTANCE_3);
			}
			if(auction.getImportance()==4){
				icons.add(IMPORTANCE_4);
			}
			
		}
		
		return icons;
	}

	public List<String> paintWinBet(List<Bet> bets){

		List<String> colors = new ArrayList();
		
		for(Bet bet:bets){
			
			if(bet.getStatus().equals(WIN_BET)){
				colors.add(WIN_BET_COLOR);
			}else{
				colors.add(NO_COLOR);
			}
			
		}
		
		return colors;
	}
	
	
	public List<String> paintWinArchiveBet(List<Archivebet> bets){

		List<String> colors = new ArrayList();
		
		for(Archivebet bet:bets){
			
			if(bet.getStatus().equals(WIN_BET)){
				colors.add(WIN_BET_COLOR);
			}else{
				colors.add(NO_COLOR);
			}
			
		}
		
		return colors;
	}

}
