package box.logic;

import java.util.ArrayList;
import java.util.List;

import box.model.Auction;

public class DecoderDbToHtml {
	
	String IMPORTANCE_1 = "fa fa-bomb w3-text-black w3-large";
	String IMPORTANCE_2 = "fa fa-bolt w3-text-yellow w3-large";
	String IMPORTANCE_3 = "fa fa-volume-off w3-text-blue w3-large";
	String IMPORTANCE_4 = "fa fa-umbrella w3-text-black w3-large";
	
	String IMPORTANCE_1_COLOR = "w3-red";
	String IMPORTANCE_4_COLOR = "w3-gray";
	String NO_COLOR = "";
	
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

}
